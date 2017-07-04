package com.lightside.fg.web.mapper;

import org.mapstruct.Qualifier;

import java.lang.annotation.*;

/**
 * @author anwar
 */

@Qualifier
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface MapperMethod {
}
