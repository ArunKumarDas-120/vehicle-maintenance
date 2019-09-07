package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_CREDENTIAL")
public class UserCredential {

    private int id;
    private String userName;
    private String password;

    @Id
    @Column(name = "USER_CRED_ID")
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @Column(name = "USER_CRED_NAME")
    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    @Column(name = "USER_CRED_PASSWORD")
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

}
