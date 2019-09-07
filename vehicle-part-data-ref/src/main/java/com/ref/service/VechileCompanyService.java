package com.ref.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ref.entity.VechileCompanyEntity;
import com.ref.repo.VechileCompanyRepo;
import com.ref.to.VechileCompanyTo;
import com.ref.util.BeanConverter;

@Service
public class VechileCompanyService {

    private final VechileCompanyRepo vechileCompanyRepo;

    public VechileCompanyService(VechileCompanyRepo vechileCompanyRepo) {
	this.vechileCompanyRepo = vechileCompanyRepo;
    }

    public VechileCompanyTo add(final VechileCompanyTo vechileCompanyTo) {
	VechileCompanyEntity result = vechileCompanyRepo
		.save(BeanConverter.mapObject(vechileCompanyTo, VechileCompanyEntity.class));
	return BeanConverter.mapObject(result, VechileCompanyTo.class);
    }

    public List<VechileCompanyTo> add(final List<VechileCompanyTo> vechileCompanyTos) {
	return vechileCompanyRepo
		.saveAll(vechileCompanyTos.stream().map(t -> BeanConverter.mapObject(t, VechileCompanyEntity.class))
			.collect(Collectors.toList()))
		.stream().map(e -> BeanConverter.mapObject(e, VechileCompanyTo.class)).collect(Collectors.toList());
    }

    public List<VechileCompanyTo> get() {
	return vechileCompanyRepo.findAll().stream().map(e -> BeanConverter.mapObject(e, VechileCompanyTo.class))
		.collect(Collectors.toList());
    }
}
