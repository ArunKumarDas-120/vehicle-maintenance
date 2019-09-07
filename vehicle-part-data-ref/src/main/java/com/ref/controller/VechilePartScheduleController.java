package com.ref.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ref.service.VechilePartScheduleService;
import com.ref.to.VechilePartScheduleTo;

@RestController
@RequestMapping(value = { "/schedule" })
public class VechilePartScheduleController {

    private final VechilePartScheduleService vechilePartScheduleService;

    public VechilePartScheduleController(VechilePartScheduleService vechilePartScheduleService) {
	this.vechilePartScheduleService = vechilePartScheduleService;
    }

    @PostMapping(value = { "/add" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public VechilePartScheduleTo add(@RequestBody final VechilePartScheduleTo vechilePartScheduleTo) {
	return vechilePartScheduleService.add(vechilePartScheduleTo);
    }

    @PostMapping(value = { "/multiadd" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public List<VechilePartScheduleTo> add(@RequestBody final List<VechilePartScheduleTo> vechilePartScheduleTo) {
	return vechilePartScheduleService.add(vechilePartScheduleTo);
    }

    @CrossOrigin
    @GetMapping(value = { "/{model}" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public List<VechilePartScheduleTo> scheduleByModel(@PathVariable("model") String model) {
	return vechilePartScheduleService.scheduleByModel(model);
    }

    @CrossOrigin
    @GetMapping(value = { "/{model}/{company}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<VechilePartScheduleTo> scheduleByModelAndCompany(@PathVariable("model") String modelName,
	    @PathVariable("company") String companyName) {
	return vechilePartScheduleService.scheduleByModelAndCompany(modelName, companyName);
    }
}
