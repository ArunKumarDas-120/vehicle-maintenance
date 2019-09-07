package com.ref.util;

import com.ref.entity.VechileCompanyEntity;
import com.ref.entity.VechileModelEntity;
import com.ref.entity.VechilePartScheduleEntity;
import com.ref.to.VechileCompanyTo;
import com.ref.to.VechileModelTo;
import com.ref.to.VechilePartScheduleTo;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public final class BeanConverter {
    private final static MapperFacade mapper;

    static {
	final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	mapperFactory.classMap(VechileCompanyTo.class, VechileCompanyEntity.class).byDefault().register();
	mapperFactory.classMap(VechileModelTo.class, VechileModelEntity.class).byDefault().register();
	mapperFactory.classMap(VechilePartScheduleTo.class, VechilePartScheduleEntity.class).byDefault().register();
	mapper = mapperFactory.getMapperFacade();
    }

    private BeanConverter() {
    }

    public static <S, T> T mapObject(S source, Class<T> clazz) {
	return mapper.map(source, clazz);
    }
}