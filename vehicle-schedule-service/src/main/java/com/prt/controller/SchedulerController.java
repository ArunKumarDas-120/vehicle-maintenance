package com.prt.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.model.VehicleInfoTo;
import com.prt.service.VehicleService;

@RestController
@RequestMapping(value = { "/schedule" })
@CrossOrigin
public class SchedulerController {

    private final VehicleService vehicleService;

    public SchedulerController(VehicleService vehicleService) {
	this.vehicleService = vehicleService;
    }

    @GetMapping(value = { "/vehicle/{vehiclenumber}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public VehicleInfoTo getSchedule(@PathVariable("vehiclenumber") String vehicleNumber) {
	return vehicleService.get(vehicleNumber);
    }

    @GetMapping(value = { "/{userid}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<VehicleInfoTo> getAllSchedule(@PathVariable("userid") int userid) {
	return vehicleService.getAllScheduleForUser(userid);
    }

    @PostMapping(value = { "/create" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public VehicleInfoTo create(@RequestBody final VehicleInfoTo vehicleInfoTo) {
	VehicleInfoTo result = vehicleService.create(vehicleInfoTo);
	return result;
    }

    @DeleteMapping(value = { "/delete/{vehiclenumber}/{userId}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public VehicleInfoTo deleteSchedule(@PathVariable("vehiclenumber") String vehicleNumber,
	    @PathVariable("userId") int userId) {
	return vehicleService.deleteSchedule(vehicleNumber, userId);
    }

}
