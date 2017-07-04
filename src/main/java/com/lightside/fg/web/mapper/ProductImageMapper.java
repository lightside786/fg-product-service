package com.lightside.fg.web.mapper;

import com.lightside.fg.domain.ProductImage;
import com.lightside.fg.web.response.dto.ProductImageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.Set;

/**
 * @author anwar
 */

@Mapper(componentModel = "spring")
public interface ProductImageMapper extends MapperAdapter<ProductImage, ProductImageDTO> {

    @MapperMethod
    @Mapping(source = "recordId", target = "id", qualifiedBy = {MapperMethod.class})
    ProductImageDTO map(ProductImage source);

    Collection<ProductImageDTO> map(Set<ProductImage> value);
}
