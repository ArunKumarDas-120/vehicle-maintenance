package com.common.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PartMaintenanceTo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String vehicleNumber;
    private LocalDate nextChangeDate;
    private int taskId;
    private LocalDate lastChangedDate;
    private String taskName;
    private Notification notify;
    private int changeAfter;

    public int getTaskId() {
	return taskId;
    }

    public void setTaskId(int taskId) {
	this.taskId = taskId;
    }

    public LocalDate getLastChangedDate() {
	return lastChangedDate;
    }

    public void setLastChangedDate(LocalDate lastChangedDate) {
	this.lastChangedDate = lastChangedDate;
    }

    public LocalDate getNextChangeDate() {
	return nextChangeDate;
    }

    public void setNextChangeDate(LocalDate nextChangeDate) {
	this.nextChangeDate = nextChangeDate;
    }

    public String getTaskName() {
	return taskName;
    }

    public void setTaskName(String taskName) {
	this.taskName = Objects.nonNull(taskName) ? taskName.trim() : taskName;
    }

    public String getVehicleNumber() {
	return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = Objects.nonNull(vehicleNumber) ? vehicleNumber.trim().toUpperCase() : vehicleNumber;
    }

    public Notification getNotify() {
	return notify;
    }

    public void setNotify(Notification notify) {
	this.notify = notify;
    }

    public int getChangeAfter() {
	return changeAfter;
    }

    public void setChangeAfter(int changeAfter) {
	this.changeAfter = changeAfter;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
	result = prime * result + ((vehicleNumber == null) ? 0 : vehicleNumber.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (Objects.isNull(obj) || (this.getClass() != obj.getClass()))
	    return false;
	PartMaintenanceTo other = (PartMaintenanceTo) obj;
	if (this.taskName == null) {
	    if (other.getTaskName() != null)
		return false;
	} else if (!this.taskName.equals(other.getTaskName()))
	    return false;
	if (this.vehicleNumber == null) {
	    if (other.getVehicleNumber() != null)
		return false;
	} else if (!this.vehicleNumber.equals(other.getVehicleNumber()))
	    return false;
	return true;
    }

}
