package com.user.dto;

import com.common.model.UserDto;

public class SignUpDto {

    private UserDto user;
    private UserCredentialDto userCredential;

    public UserDto getUser() {
	return user;
    }

    public void setUser(UserDto user) {
	this.user = user;
    }

    public UserCredentialDto getUserCredential() {
	return userCredential;
    }

    public void setUserCredential(UserCredentialDto userCredential) {
	this.userCredential = userCredential;
    }

}
