package com.lightside.fg.web.mapper;

import com.lightside.fg.domain.ProductCategory;
import com.lightside.fg.web.response.dto.ProductCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author anwar
 */

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface CategoryResponseMapper extends MapperAdapter<ProductCategory, ProductCategoryDTO> {
    
    @MapperMethod
    @Mapping(source = "recordId", target = "id", qualifiedBy = {MapperMethod.class})
    ProductCategoryDTO map(ProductCategory source);

}
