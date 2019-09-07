package com.common.model;

import java.util.Objects;

public class UserDto {

    private int userId;
    private String firstName;
    private String lastName;
    private String userEmail;

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = Objects.nonNull(firstName) ? firstName.trim() : firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = Objects.nonNull(lastName) ? lastName.trim() : lastName;
    }

    public String getUserEmail() {
	return userEmail;
    }

    public void setUserEmail(String userEmail) {
	this.userEmail = Objects.nonNull(userEmail) ? userEmail.trim() : userEmail;
    }

}
