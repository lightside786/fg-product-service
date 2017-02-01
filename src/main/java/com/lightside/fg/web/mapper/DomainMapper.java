package com.lightside.fg.web.mapper;

import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;

/**
 * @author Anwar
 */

public interface DomainMapper<S, T> extends Converter<S, T> {

    @Mapping(source = "recordId", target = "id")
    T map(S source);

    Collection<T> map(Collection<S> sources);
}
