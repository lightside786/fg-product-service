package com.lightside.fg.web.mapper;

import com.lightside.fg.domain.Product;
import com.lightside.fg.web.response.dto.ProductDTO;
import org.mapstruct.Mapper;

/**
 * @author anwar
 */

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface ProductResponseMapper extends MapperAdapter<Product, ProductDTO> {

}
