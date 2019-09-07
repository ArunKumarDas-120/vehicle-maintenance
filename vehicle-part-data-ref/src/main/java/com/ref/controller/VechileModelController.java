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

import com.ref.service.VechileModelService;
import com.ref.to.VechileModelTo;

@RestController
@RequestMapping(value = { "/model" })
public class VechileModelController {

    private final VechileModelService vechileModelService;

    public VechileModelController(VechileModelService vechileModelService) {
	this.vechileModelService = vechileModelService;
    }

    @PostMapping(value = { "/add" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public VechileModelTo add(@RequestBody final VechileModelTo vechileModelTo) {
	return vechileModelService.add(vechileModelTo);
    }

    @PostMapping(value = { "/multiadd" }, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
	    MediaType.APPLICATION_JSON_VALUE })
    public List<VechileModelTo> add(@RequestBody final List<VechileModelTo> vechileModelTo) {
	return vechileModelService.add(vechileModelTo);
    }

    @CrossOrigin
    @GetMapping(value = { "/{company}/{model}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<VechileModelTo> modelByCompanyAndModel(@PathVariable("company") final String companyName,
	    @PathVariable("model") final String modelName) {
	return vechileModelService.modelByCompanyAndModel(modelName, companyName);
    }

    @CrossOrigin
    @GetMapping(value = { "/{company}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<VechileModelTo> modelByCompany(@PathVariable("company") final String companyName) {
	return vechileModelService.modelByCompany(companyName);
    }
}
