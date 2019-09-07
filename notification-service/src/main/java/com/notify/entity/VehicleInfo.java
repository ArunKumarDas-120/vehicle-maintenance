package com.notify.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "VEHICLE_TO_NOTIFY")
@Access(AccessType.PROPERTY)
public class VehicleInfo {

    private String vehicleNumber;
    private String model;
    private String company;
    private int dailyRunningInKM;
    private int userId;
    private List<VehicleScheduleInfo> vehicleScheduleInfo = new ArrayList<>(0);

    @Id
    @Column(name = "VEHICLE_NUMBER")
    public String getVehicleNumber() {
	return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = Objects.nonNull(vehicleNumber) ? vehicleNumber.trim().toUpperCase() : vehicleNumber;
    }

    @Column(name = "DAILY_RUNNING_IN_KM")
    public int getDailyRunningInKM() {
	return dailyRunningInKM;
    }

    public void setDailyRunningInKM(int dailyRunningInKM) {
	this.dailyRunningInKM = dailyRunningInKM;
    }

    @Column(name = "VEHICLE_MODEL")
    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = Objects.nonNull(model) ? model.trim() : model;
    }

    @Column(name = "VEHICLE_COMPANY")
    public String getCompany() {
	return company;
    }

    public void setCompany(String company) {
	this.company = Objects.nonNull(company) ? company.trim() : company;
    }

    @Column(name = "U_ID")
    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "VEH_NUMBER", referencedColumnName = "VEHICLE_NUMBER")
    @NotFound(action = NotFoundAction.IGNORE)
    public List<VehicleScheduleInfo> getVehicleScheduleInfo() {
	return vehicleScheduleInfo;
    }

    public void setVehicleScheduleInfo(List<VehicleScheduleInfo> vehicleScheduleInfo) {
	this.vehicleScheduleInfo = vehicleScheduleInfo;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((vehicleNumber == null) ? 0 : vehicleNumber.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (Objects.isNull(obj) || (getClass() != obj.getClass()))
	    return false;
	VehicleInfo other = (VehicleInfo) obj;
	if (vehicleNumber == null) {
	    if (other.vehicleNumber != null)
		return false;
	} else if (!vehicleNumber.equals(other.vehicleNumber))
	    return false;
	return true;
    }

}
