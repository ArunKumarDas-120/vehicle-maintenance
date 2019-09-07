package com.common.model;

import java.io.Serializable;

public class MessageDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private UserDto user;
    private VehicleInfoTo vehicleInfo;
    private String messageSelector;

    public MessageDto() {

    }

    public MessageDto(UserDto user, VehicleInfoTo vehicleInfo, String messageSelector) {
	this.user = user;
	this.vehicleInfo = vehicleInfo;
	this.messageSelector = messageSelector;
    }

    public UserDto getUser() {
	return user;
    }

    public void setUser(UserDto user) {
	this.user = user;
    }

    public VehicleInfoTo getVehicleInfo() {
	return vehicleInfo;
    }

    public void setVehicleInfo(VehicleInfoTo vehicleInfo) {
	this.vehicleInfo = vehicleInfo;
    }

    public String getMessageSelector() {
	return messageSelector;
    }

    public void setMessageSelector(String messageSelector) {
	this.messageSelector = messageSelector;
    }

}
