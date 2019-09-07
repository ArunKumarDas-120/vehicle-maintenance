package com.ref.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ref.entity.VechilePartScheduleEntity;
import com.ref.repo.VechilePartScheduleRepo;
import com.ref.to.VechilePartScheduleTo;
import com.ref.util.BeanConverter;

@Service
public class VechilePartScheduleService {

    private final VechilePartScheduleRepo vechilePartScheduleRepo;

    public VechilePartScheduleService(VechilePartScheduleRepo vechilePartScheduleRepo) {
	this.vechilePartScheduleRepo = vechilePartScheduleRepo;
    }

    public VechilePartScheduleTo add(final VechilePartScheduleTo vechilePartScheduleTo) {
	VechilePartScheduleEntity result = vechilePartScheduleRepo
		.save(BeanConverter.mapObject(vechilePartScheduleTo, VechilePartScheduleEntity.class));
	return BeanConverter.mapObject(result, VechilePartScheduleTo.class);
    }

    public List<VechilePartScheduleTo> add(final List<VechilePartScheduleTo> vechilePartScheduleTo) {
	return vechilePartScheduleRepo
		.saveAll(vechilePartScheduleTo.stream()
			.map(t -> BeanConverter.mapObject(t, VechilePartScheduleEntity.class))
			.collect(Collectors.toList()))
		.stream().map(e -> BeanConverter.mapObject(e, VechilePartScheduleTo.class))
		.collect(Collectors.toList());
    }

    public List<VechilePartScheduleTo> scheduleByModel(String model) {
	return vechilePartScheduleRepo.findVechilePartScheduleByModel(model).stream()
		.map(e -> BeanConverter.mapObject(e, VechilePartScheduleTo.class)).collect(Collectors.toList());
    }

    public List<VechilePartScheduleTo> scheduleByModelAndCompany(String modelName, String companyName) {
	return vechilePartScheduleRepo.findVechilePartScheduleByModelAndCompany(modelName, companyName).stream()
		.map(e -> BeanConverter.mapObject(e, VechilePartScheduleTo.class)).collect(Collectors.toList());
    }
}
