package com.prt.entity;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "VEHICLE_INFO")
@Access(AccessType.PROPERTY)
public class VehicleInfoEntity {

    @NotEmpty(message = "Vehicle Number  empty not allowed")
    private String vehicleNumber;
    @Min(value = 1, message = "Daily running in Km  0 or negative not allowed")
    private int dailyRunningInKM;
    @NotEmpty(message = "Model Number  empty not allowed")
    private String model;
    @NotEmpty(message = "Company  empty not allowed")
    private String company;
    @Min(value = 0, message = "userid  negative not allowed")
    private int userId;
    private List<PartMaintenanceTaskEntity> partMaintenanceTask = new ArrayList<>(0);

    @Id
    @Column(name = "VEH_NUMBER")
    public String getVehicleNumber() {
	return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
	this.vehicleNumber = vehicleNumber;
    }

    @Column(name = "DAILY_RUNNING_KM")
    public int getDailyRunningInKM() {
	return dailyRunningInKM;
    }

    public void setDailyRunningInKM(int dailyRunningInKM) {
	this.dailyRunningInKM = dailyRunningInKM;
    }

    @Column(name = "MODEL")
    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    @Column(name = "COMPANY")
    public String getCompany() {
	return company;
    }

    public void setCompany(String company) {
	this.company = company;
    }

    @Column(name = "USER_ID")
    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_NUMBER", referencedColumnName = "VEH_NUMBER")
    @NotFound(action = NotFoundAction.IGNORE)
    public List<PartMaintenanceTaskEntity> getPartMaintenanceTask() {
	return partMaintenanceTask;
    }

    public void setPartMaintenanceTask(List<PartMaintenanceTaskEntity> partMaintenanceTask) {
	if (Objects.nonNull(partMaintenanceTask))
	    this.partMaintenanceTask = partMaintenanceTask;
    }

}
