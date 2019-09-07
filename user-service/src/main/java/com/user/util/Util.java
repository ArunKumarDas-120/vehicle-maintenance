package com.user.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;

import com.common.model.UserDto;
import com.user.dto.UserCredentialDto;
import com.user.entity.User;
import com.user.entity.UserCredential;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class Util {

    private final static MapperFacade mapper;
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    static {
	final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	mapperFactory.classMap(UserDto.class, User.class).byDefault().register();
	mapperFactory.classMap(UserCredentialDto.class, UserCredential.class).byDefault().register();
	mapper = mapperFactory.getMapperFacade();
    }

    private Util() {
    }

    public static <S, T> T mapObject(S source, Class<T> clazz) {
	return mapper.map(source, clazz);
    }

    public static String sanitizeString(final String inputString) {
	String result = inputString;
	if (StringUtils.isNotEmpty(result))
	    result = result.trim();
	return result;
    }

    public static boolean isNullOrEmpty(final String inputString) {
	return StringUtils.isEmpty(inputString);
    }

    public static <T> void validateData(T data) {
	Set<ConstraintViolation<T>> errorMsg = validator.validate(data);
	if (!errorMsg.isEmpty())
	    throw new ConstraintViolationException(errorMsg);
    }
}
