package com.lightside.fg.web.mapper;

import com.lightside.fg.domain.ProductPrice;
import com.lightside.fg.web.response.dto.ProductPriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.Set;

/**
 * @author anwar
 */

@Mapper(componentModel = "spring", uses = {BigDecimalMapper.class, DateMapper.class})
public interface ProductPriceMapper extends MapperAdapter<ProductPrice, ProductPriceDTO> {

    @MapperMethod
    @Mapping(source = "recordId", target = "id", qualifiedBy = {MapperMethod.class})
    ProductPriceDTO map(ProductPrice source);

    Collection<ProductPriceDTO> map(Set<ProductPrice> value);

}
