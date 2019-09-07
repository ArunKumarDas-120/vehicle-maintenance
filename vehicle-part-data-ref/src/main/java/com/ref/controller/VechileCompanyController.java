package com.ref.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ref.service.VechileCompanyService;
import com.ref.to.VechileCompanyTo;

@RestController
@RequestMapping(value = { "/company" })
public class VechileCompanyController {

    private final VechileCompanyService vechileCompanyService;

    public VechileCompanyController(VechileCompanyService vechileCompanyService) {
	this.vechileCompanyService = vechileCompanyService;
    }

    @PostMapping(value = { "/add" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public VechileCompanyTo add(@RequestBody final VechileCompanyTo vechileCompanyTo) {
	return vechileCompanyService.add(vechileCompanyTo);
    }

    @PostMapping(value = { "/multiadd" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public List<VechileCompanyTo> add(@RequestBody final List<VechileCompanyTo> vechileCompanyTo) {
	return vechileCompanyService.add(vechileCompanyTo);
    }

    @CrossOrigin
    @GetMapping(value = { "/getall" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<VechileCompanyTo> get() {
	return vechileCompanyService.get();
    }
}
