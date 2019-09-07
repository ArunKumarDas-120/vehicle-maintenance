package com.notify.util;

public interface Mapper<E, D> {

    public E mapDtoToEntity(D dto);
}
