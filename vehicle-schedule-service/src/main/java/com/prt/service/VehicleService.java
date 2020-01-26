package com.prt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.common.model.MessageDto;
import com.common.model.UserDto;
import com.common.model.VehicleInfoTo;
import com.prt.entity.VehicleInfoEntity;
import com.prt.error.DataException;
import com.prt.event.ActionEvent;
import com.prt.repo.UserRepo;
import com.prt.repo.VehicleRepo;
import com.prt.util.BeanConverter;

@Service
public class VehicleService {

    private final VehicleRepo vehicleRepo;
    private final UserRepo userRepo;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final ApplicationContext applicationContext;

    public VehicleService(VehicleRepo vehicleRepo, UserRepo userRepo,
	    ApplicationEventPublisher applicationEventPublisher, ApplicationContext applicationContext) {
	this.vehicleRepo = vehicleRepo;
	this.userRepo = userRepo;
	this.applicationEventPublisher = applicationEventPublisher;
	this.applicationContext = applicationContext;
    }

    public VehicleInfoTo get(final String vehicleNumber) {
	return vehicleRepo.findByVehicleNumberIgnoreCase(vehicleNumber)
		.map(v -> BeanConverter.mapObject(v, VehicleInfoTo.class)).orElseGet(() -> new VehicleInfoTo());
    }

    public List<VehicleInfoTo> getAllScheduleForUser(int userId) {
	return vehicleRepo.findByUserId(userId).stream().map(v -> BeanConverter.mapObject(v, VehicleInfoTo.class))
		.collect(Collectors.toList());
    }

    public VehicleInfoTo create(final VehicleInfoTo vehicleInfoTo) {
	vehicleInfoTo.getPartMaintenanceTask().forEach(p -> p.setNextChangeDate(p.getLastChangedDate()
		.plusDays(Math.floorDiv(p.getChangeAfter(), vehicleInfoTo.getDailyRunningInKM()))));
	vehicleRepo.save(BeanConverter.mapObject(vehicleInfoTo, VehicleInfoEntity.class));
	UserDto user = userRepo.getUser(vehicleInfoTo.getUserId());
	VehicleInfoTo savedData = vehicleRepo.findById(vehicleInfoTo.getVehicleNumber())
		.map(v -> BeanConverter.mapObject(v, VehicleInfoTo.class)).orElseThrow(
			() -> new DataException("No record found for vehicle " + vehicleInfoTo.getVehicleNumber(), ""));
	applicationEventPublisher.publishEvent(getActionEvent(user, savedData, "CREATE"));
	return savedData;
    }

    public VehicleInfoTo deleteSchedule(final String vehicleNumber, int userId) {
	VehicleInfoTo deleted = vehicleRepo.findByVehicleNumberIgnoreCaseAndUserId(vehicleNumber, userId).map(v -> {
	    vehicleRepo.delete(v);
	    return BeanConverter.mapObject(v, VehicleInfoTo.class);
	}).orElseThrow(() -> new DataException("No record found for vehicle " + vehicleNumber, ""));
	UserDto user = userRepo.getUser(deleted.getUserId());
	applicationEventPublisher.publishEvent(getActionEvent(user, deleted, "DELETE"));
	return deleted;
    }

    private ActionEvent getActionEvent(UserDto user, VehicleInfoTo vehicleInfo, String messageSelector) {
	return applicationContext.getBean(ActionEvent.class,
		applicationContext.getBean(MessageDto.class, user, vehicleInfo, messageSelector));
    }
}
