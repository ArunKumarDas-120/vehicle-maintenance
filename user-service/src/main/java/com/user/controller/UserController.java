package com.user.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.model.UserDto;
import com.user.dto.SignUpDto;
import com.user.dto.UserCredentialDto;
import com.user.service.UserService;

@RestController
@RequestMapping(value = { "/user" })
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
	this.userService = userService;
    }

    @PostMapping(value = { "/signup" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public UserDto singUp(@RequestBody final SignUpDto signUpDto) {
	return userService.signUp(signUpDto);
    }

    @PostMapping(value = { "/signin" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public UserDto signIn(@RequestBody final UserCredentialDto userCredentialDto) {
	return userService.signIn(userCredentialDto);
    }

    @GetMapping(value = { "/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public UserDto getUser(@PathVariable("id") final int id) {
	return userService.findById(id);
    }
}
