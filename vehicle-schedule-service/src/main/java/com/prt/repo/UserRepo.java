package com.prt.repo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.common.model.UserDto;

@FeignClient(name = "USER-SERVICE", url = "http://localhost:4002")
public interface UserRepo {

    @GetMapping(value = { "/user/{id}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public UserDto getUser(@PathVariable("id") final int id);

}
