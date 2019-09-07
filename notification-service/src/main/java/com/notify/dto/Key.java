package com.notify.dto;

public class Key {

    private String userName;
    private String vehicle;
    private String email;

    public Key(String userName, String vehicle, String email) {
	this.userName = userName;
	this.vehicle = vehicle;
	this.email = email;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getVehicle() {
	return vehicle;
    }

    public void setVehicle(String vehicle) {
	this.vehicle = vehicle;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
	Key other = (Key) obj;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (userName == null) {
	    if (other.userName != null)
		return false;
	} else if (!userName.equals(other.userName))
	    return false;
	if (vehicle == null) {
	    if (other.vehicle != null)
		return false;
	} else if (!vehicle.equals(other.vehicle))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return String.format("userName=%s, vehicle=%s, email=%s", userName, vehicle, email);
    }

}
