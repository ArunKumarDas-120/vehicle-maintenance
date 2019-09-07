package com.notify.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.common.model.MessageDto;
import com.notify.dto.Key;
import com.notify.dto.NotificatonDTO;
import com.notify.entity.NotificationMain;
import com.notify.repo.NotificationRepo;
import com.notify.util.Mapper;

@Service
public class NotificationService {

    private final NotificationRepo notificationRepo;
    private final Mapper<NotificationMain, MessageDto> mapper;

    public NotificationService(NotificationRepo notificationRepo, Mapper<NotificationMain, MessageDto> mapper) {
	this.notificationRepo = notificationRepo;
	this.mapper = mapper;
    }

    public void saveOrUpdate(MessageDto messageDto) {
	NotificationMain receivedData = mapper.mapDtoToEntity(messageDto);
	NotificationMain processedBeforeSaving = notificationRepo.findById(messageDto.getUser().getUserId()).map(n -> {
	    if (!n.getVehiclesList().stream()
		    .anyMatch(v -> (v.getUserId() == receivedData.getVehiclesList().get(0).getUserId()) && (receivedData
			    .getVehiclesList().get(0).getVehicleNumber().equalsIgnoreCase(v.getVehicleNumber())))) {
		n.getVehiclesList().addAll(receivedData.getVehiclesList());
	    } else {
		n.setVehiclesList(n.getVehiclesList().stream()
			.map(v -> (v.getUserId() == receivedData.getVehiclesList().get(0).getUserId()) && (receivedData
				.getVehiclesList().get(0).getVehicleNumber().equalsIgnoreCase(v.getVehicleNumber()))
					? receivedData.getVehiclesList().get(0)
					: v)
			.collect(Collectors.toList()));
	    }
	    return n;
	}).orElseGet(() -> {
	    return receivedData;
	});
	notificationRepo.save(processedBeforeSaving);
    }

    public void deleteVehicleAndSchedule(MessageDto messageDto) {
	NotificationMain receivedData = mapper.mapDtoToEntity(messageDto);
	NotificationMain processedBeforeSaving = notificationRepo.findById(receivedData.getUserId()).map(n -> {
	    n.setVehiclesList(n.getVehiclesList().stream()
		    .filter(v -> !((v.getUserId() == receivedData.getVehiclesList().get(0).getUserId()) && (receivedData
			    .getVehiclesList().get(0).getVehicleNumber().equalsIgnoreCase(v.getVehicleNumber()))))
		    .collect(Collectors.toList()));
	    return n;
	}).orElse(new NotificationMain());
	if (null != processedBeforeSaving.getUserEmail()) {
	    if (processedBeforeSaving.getVehiclesList().isEmpty())
		notificationRepo.deleteById(processedBeforeSaving.getUserId());
	    else
		notificationRepo.save(processedBeforeSaving);
	} else {
	    System.out.println("no data to remove");
	}
    }

    public Map<Key, List<NotificatonDTO>> getNotificationFor(int numberOfDaysLeft) {
	return notificationRepo.getScheduleToNotify(numberOfDaysLeft).stream()
		.collect(Collectors.groupingBy(n -> new Key(n.getUserName(), n.getVehicleInfo(), n.getEmail())));
    }

    public Map<Key, List<NotificatonDTO>> getOverdueSchedule() {
	return notificationRepo.getOverdueSchedule().stream()
		.collect(Collectors.groupingBy(n -> new Key(n.getUserName(), n.getVehicleInfo(), n.getEmail())));
    }
}
