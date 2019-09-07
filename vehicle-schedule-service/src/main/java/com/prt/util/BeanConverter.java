package com.prt.util;

import com.common.model.PartMaintenanceTo;
import com.common.model.VehicleInfoTo;
import com.prt.entity.PartMaintenanceTaskEntity;
import com.prt.entity.VehicleInfoEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public final class BeanConverter {
    private final static MapperFacade mapper;

    static {
	final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	mapperFactory.classMap(VehicleInfoTo.class, VehicleInfoEntity.class)
		.fieldMap("partMaintenanceTask{}", "partMaintenanceTask{}").mapNulls(true).mapNullsInReverse(true).add()
		.byDefault().register();
	mapperFactory.classMap(PartMaintenanceTo.class, PartMaintenanceTaskEntity.class).byDefault().register();
	mapper = mapperFactory.getMapperFacade();
    }

    private BeanConverter() {
    }

    public static <S, T> T mapObject(S source, Class<T> clazz) {
	return mapper.map(source, clazz);
    }
}