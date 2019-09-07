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
@Table(name = "NOTIFICATION_MAIN")
@Access(AccessType.PROPERTY)
public class NotificationMain {

    private int userId;
    private String firstName;
    private String lastName;
    private String userEmail;
    private List<VehicleInfo> vehiclesList = new ArrayList<>(0);

    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    @Column(name = "USER_FIRST_NAME")
    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = Objects.nonNull(firstName) ? firstName.trim() : firstName;
    }

    @Column(name = "USER_LAST_NAME")
    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = Objects.nonNull(lastName) ? lastName.trim() : lastName;
    }

    @Column(name = "USER_EMAIL")
    public String getUserEmail() {
	return userEmail;
    }

    public void setUserEmail(String userEmail) {
	this.userEmail = Objects.nonNull(userEmail) ? userEmail.trim() : userEmail;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "U_ID", referencedColumnName = "USER_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public List<VehicleInfo> getVehiclesList() {
	return vehiclesList;
    }

    public void setVehiclesList(List<VehicleInfo> vehiclesList) {
	this.vehiclesList = vehiclesList;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + userId;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (Objects.isNull(obj) || (getClass() != obj.getClass()))
	    return false;
	NotificationMain other = (NotificationMain) obj;
	if (userId != other.userId)
	    return false;
	return true;
    }

}
