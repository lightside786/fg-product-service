package com.lightside.fg.web.controller;

import com.lightside.fg.domain.ProductCategory;
import com.lightside.fg.exception.NoRecordFoundException;
import com.lightside.fg.repository.CategoryRepository;
import com.lightside.fg.web.mapper.CategoryResponseMapper;
import com.lightside.fg.web.response.dto.ProductCategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("api/v1/categories")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryResponseMapper categoryResponseMapper;

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ProductCategoryDTO getCategory(@PathVariable(value = "id") String id) {
        ProductCategory productCategory = null;
        if (StringUtils.isNotEmpty(id)) {
            log.info("Retrieving category details for id : {}", id);
            productCategory = categoryRepository.findByRecordId(id);
            log.info("Retrieved productCategory with details : {}", productCategory);
        }
        if (productCategory == null) {
            throw new NoRecordFoundException("notfound.error.key", "notfound.error.message");
        }
        return categoryResponseMapper.map(productCategory);
    }

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public Page<ProductCategoryDTO> getCategories(Pageable pageable) {
        log.info("Retrieving category details with page :{}", pageable);
        Page<ProductCategory> results = categoryRepository.findAll(pageable);
        if (results.getNumberOfElements() == 0) {
            throw new NoRecordFoundException("notfound.error.key", "notfound.error.message");
        }
        Page<ProductCategoryDTO> categoryDTOS = results.map(categoryResponseMapper);
        log.info("Categories : {}", categoryDTOS.getContent());
        return categoryDTOS;
    }
}
