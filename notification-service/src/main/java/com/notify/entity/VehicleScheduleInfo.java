package com.notify.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.common.model.Notification;

@Entity
@Table(name = "SCHEDULES_TO_NOTIFY")
@Access(AccessType.PROPERTY)
public class VehicleScheduleInfo {

    private int taskId;
    private LocalDate lastChangedDate;
    private LocalDate nextChangeDate;
    private String taskName;
    private String vehicleNumber;
    private Notification notify;
    private int changeAfter;

    @Id
    @Column(name = "TASK_ID")
    public int getTaskId() {
	return taskId;
    }

    public void setTaskId(int taskId) {
	this.taskId = taskId;
    }

    @Column(name = "LAST_CHANGED_DATE")
    public LocalDate getLastChangedDate() {
	return lastChangedDate;
    }

    public void setLastChangedDate(LocalDate lastChangedDate) {
	this.lastChangedDate = lastChangedDate;
    }

    @Column(name = "NEXT_CHANGE_DATE")
    public LocalDate getNextChangeDate() {
	return nextChangeDate;
    }

    public void setNextChangeDate(LocalDate nextChangeDate) {
	this.nextChangeDate = nextChangeDate;
    }

    @Column(name = "TASK_NAME")
    public String getTaskName() {
	return taskName;
    }

    public void setTaskName(String taskName) {
	this.taskName = taskName;
    }

    @Column(name = "VEH_NUMBER")
    public String getVehicleNumber() {
	return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = Objects.nonNull(vehicleNumber) ? vehicleNumber.trim().toUpperCase() : vehicleNumber;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "NOTIFY")
    public Notification getNotify() {
	return notify;
    }

    public void setNotify(Notification notify) {
	this.notify = notify;
    }

    @Column(name = "CHANGE_AFTER")
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
	result = prime * result + taskId;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	VehicleScheduleInfo other = (VehicleScheduleInfo) obj;
	if (taskId != other.taskId)
	    return false;
	return true;
    }

}
