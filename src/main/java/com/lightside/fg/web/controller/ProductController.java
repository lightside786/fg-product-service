package com.lightside.fg.web.controller;

import com.lightside.fg.domain.Product;
import com.lightside.fg.exception.NoRecordFoundException;
import com.lightside.fg.repository.ProductRepository;
import com.lightside.fg.web.mapper.ProductResponseMapper;
import com.lightside.fg.web.response.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Anwar
 */

@RestController
@Slf4j
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductRepository repository;
    private ProductResponseMapper responseMapper;

    public ProductController(ProductRepository repository, ProductResponseMapper responseMapper) {
        this.repository = repository;
        this.responseMapper = responseMapper;
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ProductDTO getProduct(@PathVariable(value = "id") String id) {
        Product product = null;
        if (StringUtils.isNotEmpty(id)) {
            log.info("Retrieving product details for id : {}", id);
            product = repository.findByRecordId(id);
            log.info("Retrieved product with details : {}", product);
        }
        if (product == null) {
            throw new NoRecordFoundException("notfound.error.key", "notfound.error.message");
        }
        return responseMapper.map(product);
    }

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public Page<ProductDTO> getProducts(Pageable pageable) {
        log.info("Retrieving product details with page request : {}", pageable);
        Page<Product> results = repository.findAll(pageable);
        if (results.getNumberOfElements() == 0) {
            throw new NoRecordFoundException("notfound.error.key", "notfound.error.message");
        }
        Page<ProductDTO> productDTOS = results.map(responseMapper);
        log.info("Products returned : {}", productDTOS.getContent());
        return productDTOS;
    }

}
