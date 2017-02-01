package com.lightside.fg.web.mapper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Anwar
 */
public interface MapperAdapter<S, T> extends DomainMapper<S, T> {

    @Override
    default Collection<T> map(Collection<S> sources) {
        if (sources == null) {
            return Collections.emptyList();
        }
        final Collection<T> destTypes = new ArrayList<>(sources.size());
        destTypes.addAll(sources.stream().map(this::map).collect(Collectors.toList()));
        return destTypes;
    }

    @Override
    default T convert(S source) {
        return this.map(source);
    }
}
