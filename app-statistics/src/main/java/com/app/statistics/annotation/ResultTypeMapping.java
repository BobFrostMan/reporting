package com.app.statistics.annotation;

import com.app.statistics.model.Group;
import com.app.statistics.model.MetaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ResultTypeMapping {
    Group group();
    MetaType type();
}