package com.app.statistics.mapper.impl;

import com.app.statistics.mapper.BeanMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class DozerBeanMapperImpl implements BeanMapper {
    private static final String BEAN_MAPPER_CONFIGURATION = "bean-mapper.xml";

    private List<String> mapperConfigurations = new ArrayList<>();
    private Mapper mapper;

    @PostConstruct
    private void init(){
        mapperConfigurations.add(BEAN_MAPPER_CONFIGURATION);
        mapper = new DozerBeanMapper(mapperConfigurations);
    }
    @Override
    public <T> T map(final Object source, final Class<T> destinationClass) {
        return mapper.map(source, destinationClass);
    }
}
