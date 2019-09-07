package com.notify.dto;

import java.time.LocalDate;

public class NotificatonDTO {

    private String userName;
    private String email;
    private String vehicleInfo;
    private String taskName;
    private LocalDate lastChangedDate;

    public NotificatonDTO() {

    }

    public NotificatonDTO(String userName, String email, String vehicleInfo, String taskName,
	    LocalDate lastChangedDate) {
	this.userName = userName;
	this.email = email;
	this.vehicleInfo = vehicleInfo;
	this.taskName = taskName;
	this.lastChangedDate = lastChangedDate;
    }

    public String getUserName() {
	return userName;
    }

    public String getEmail() {
	return email;
    }

    public String getVehicleInfo() {
	return vehicleInfo;
    }

    public String getTaskName() {
	return taskName;
    }

    public LocalDate getLastChangedDate() {
	return lastChangedDate;
    }

    @Override
    public String toString() {
	return String.format("userName=%s, email=%s, vehicleInfo=%s, taskName=%s, lastChangedDate=%s", userName, email,
		vehicleInfo, taskName, lastChangedDate);
    }

}
