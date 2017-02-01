package com.lightside.fg.service;

import com.lightside.fg.domain.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by achirakkattil on 12/2/16.
 */

public interface CategoryService {

    Page<ProductCategory> getAll(Pageable pageable);

}
