package com.lightside.fg.web.mapper;

import org.springframework.core.convert.converter.Converter;

import java.util.Collection;

/**
 * @author Anwar
 */

public interface DomainMapper<S, T> extends Converter<S, T> {

    T map(S source);

    Collection<T> map(Collection<S> sources);
}
