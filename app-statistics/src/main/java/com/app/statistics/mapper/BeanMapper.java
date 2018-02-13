package com.app.statistics.mapper;

public interface BeanMapper {
    <T> T map(final Object source, final Class<T> destinationClass);
}
