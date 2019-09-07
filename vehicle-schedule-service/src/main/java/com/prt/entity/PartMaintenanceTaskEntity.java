package com.prt.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.common.model.Notification;

@Entity
@Table(name = "PART_MAINTENANCE_SCHEDULE")
@Access(AccessType.PROPERTY)
public class PartMaintenanceTaskEntity {

    @Min(value = 0, message = "negative not allowed")
    private int taskId;
    @NotNull(message = "empty not allowed")
    private LocalDate lastChangedDate;
    private LocalDate nextChangeDate;
    @NotEmpty(message = "empty not allowed")
    private String taskName;
    private String vehicleNumber;
    @NotNull(message = "empty not allowed")
    private Notification notify;
    @Min(value = 100, message = "minimum 100 allowed")
    private int changeAfter;

    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "VEHICLE_NUMBER")
    public String getVehicleNumber() {
	return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = vehicleNumber;
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
	PartMaintenanceTaskEntity other = (PartMaintenanceTaskEntity) obj;
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
