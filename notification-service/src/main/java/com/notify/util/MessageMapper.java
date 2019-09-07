package com.notify.util;

import org.springframework.stereotype.Component;

import com.common.model.MessageDto;
import com.notify.entity.NotificationMain;
import com.notify.entity.VehicleInfo;
import com.notify.entity.VehicleScheduleInfo;

@Component
public class MessageMapper implements Mapper<NotificationMain, MessageDto> {

    @Override
    public NotificationMain mapDtoToEntity(MessageDto dto) {
	NotificationMain user = new NotificationMain();
	user.setUserId(dto.getUser().getUserId());
	user.setFirstName(dto.getUser().getFirstName());
	user.setLastName(dto.getUser().getLastName());
	user.setUserEmail(dto.getUser().getUserEmail());
	VehicleInfo vehicleInfo = new VehicleInfo();
	vehicleInfo.setCompany(dto.getVehicleInfo().getCompany());
	vehicleInfo.setDailyRunningInKM(dto.getVehicleInfo().getDailyRunningInKM());
	vehicleInfo.setModel(dto.getVehicleInfo().getModel());
	vehicleInfo.setVehicleNumber(dto.getVehicleInfo().getVehicleNumber());
	vehicleInfo.setUserId(dto.getVehicleInfo().getUserId());
	dto.getVehicleInfo().getPartMaintenanceTask().forEach(p -> {
	    VehicleScheduleInfo scheduleInfo = new VehicleScheduleInfo();
	    scheduleInfo.setChangeAfter(p.getChangeAfter());
	    scheduleInfo.setLastChangedDate(p.getLastChangedDate());
	    scheduleInfo.setNextChangeDate(p.getNextChangeDate());
	    scheduleInfo.setTaskName(p.getTaskName());
	    scheduleInfo.setVehicleNumber(p.getVehicleNumber());
	    scheduleInfo.setTaskId(p.getTaskId());
	    scheduleInfo.setNotify(p.getNotify());
	    vehicleInfo.getVehicleScheduleInfo().add(scheduleInfo);
	});
	user.getVehiclesList().add(vehicleInfo);
	return user;
    }

}
