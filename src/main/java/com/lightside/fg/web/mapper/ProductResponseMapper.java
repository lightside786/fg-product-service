package com.lightside.fg.web.mapper;

import com.lightside.fg.domain.Product;
import com.lightside.fg.web.response.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author anwar
 */

@Mapper(componentModel = "spring", uses =
        {       DateMapper.class,
                CategoryResponseMapper.class,
                ProductImageMapper.class,
                ProductPriceMapper.class
        })
public interface ProductResponseMapper extends MapperAdapter<Product, ProductDTO> {

    @MapperMethod
    @Mapping(source = "recordId", target = "id", qualifiedBy = {MapperMethod.class})
    ProductDTO map(Product source);

}
