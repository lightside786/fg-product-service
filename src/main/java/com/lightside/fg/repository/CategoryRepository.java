package com.lightside.fg.repository;

import com.lightside.fg.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by achirakkattil on 12/3/16.
 */

public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {

    ProductCategory findByRecordId(@Param("recordId") final String recordId);
}
