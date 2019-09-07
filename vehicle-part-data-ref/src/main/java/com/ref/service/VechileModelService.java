package com.ref.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ref.entity.VechileModelEntity;
import com.ref.repo.VechileModelRepo;
import com.ref.to.VechileModelTo;
import com.ref.util.BeanConverter;

@Service
public class VechileModelService {

    private final VechileModelRepo vechileModelRepo;

    public VechileModelService(VechileModelRepo vechileModelRepo) {
	this.vechileModelRepo = vechileModelRepo;
    }

    public VechileModelTo add(final VechileModelTo vechileModelTo) {
	VechileModelEntity result = vechileModelRepo
		.save(BeanConverter.mapObject(vechileModelTo, VechileModelEntity.class));
	return BeanConverter.mapObject(result, VechileModelTo.class);
    }

    public List<VechileModelTo> add(final List<VechileModelTo> vechileModelTo) {
	return vechileModelRepo
		.saveAll(vechileModelTo.stream().map(t -> BeanConverter.mapObject(t, VechileModelEntity.class))
			.collect(Collectors.toList()))
		.stream().map(e -> BeanConverter.mapObject(e, VechileModelTo.class)).collect(Collectors.toList());
    }

    public List<VechileModelTo> modelByCompanyAndModel(final String modelName, final String companyName) {
	return vechileModelRepo.findModelByCompanyAndModel(modelName, companyName).stream()
		.map(e -> BeanConverter.mapObject(e, VechileModelTo.class)).collect(Collectors.toList());
    }

    public List<VechileModelTo> modelByCompany(final String companyName) {
	return vechileModelRepo.findModelByCompany(companyName).stream()
		.map(e -> BeanConverter.mapObject(e, VechileModelTo.class)).collect(Collectors.toList());
    }
}
