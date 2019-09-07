package com.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehicleInfoTo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vehicleNumber;
    private String model;
    private String company;
    private int dailyRunningInKM;
    private int userId;
    private List<PartMaintenanceTo> partMaintenanceTask = new ArrayList<>(0);

    public String getVehicleNumber() {
	return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = Objects.nonNull(vehicleNumber) ? vehicleNumber.trim().toUpperCase() : vehicleNumber;
    }

    public int getDailyRunningInKM() {
	return dailyRunningInKM;
    }

    public void setDailyRunningInKM(int dailyRunningInKM) {
	this.dailyRunningInKM = dailyRunningInKM;
    }

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = Objects.nonNull(model) ? model.trim() : model;
    }

    public String getCompany() {
	return company;
    }

    public void setCompany(String company) {
	this.company = Objects.nonNull(company) ? company.trim() : company;
    }

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public List<PartMaintenanceTo> getPartMaintenanceTask() {
	return partMaintenanceTask;
    }

    public void setPartMaintenanceTask(List<PartMaintenanceTo> partMaintenanceTask) {
	if (Objects.nonNull(partMaintenanceTask))
	    this.partMaintenanceTask = partMaintenanceTask;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Objects.isNull(vehicleNumber)) ? 0 : vehicleNumber.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (Objects.isNull(obj) || (this.getClass() != obj.getClass()))
	    return false;
	VehicleInfoTo other = (VehicleInfoTo) obj;
	if (this.vehicleNumber == null) {
	    if (other.vehicleNumber != null)
		return false;
	} else if (!this.vehicleNumber.equals(other.vehicleNumber))
	    return false;
	return true;
    }

}
