package com.user.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "USERS")
@Access(AccessType.PROPERTY)
public class User {

    private int userId;
    @NotEmpty(message = "Empty or blank not allowed")
    private String firstName;
    @NotEmpty(message = "Empty or blank not allowed")
    private String lastName;
    @NotEmpty(message = "Empty or blank not allowed")
    @Pattern(flags = {
	    Pattern.Flag.CASE_INSENSITIVE }, regexp = "[a-zA-Z0-9_-]+[@][a-zA-Z]+([.][a-zA-Z]+)+", message = "Email not in validate formate")
    private String userEmail;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    @Column(name = "FIRST_NAME", nullable = false)
    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", nullable = false)
    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    @Column(name = "EMAIL", nullable = false, unique = true)
    public String getUserEmail() {
	return userEmail;
    }

    public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
    }

}
