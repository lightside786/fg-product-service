package com.lightside.fg.repository;

import com.lightside.fg.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author anwar
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Product findByRecordId(@Param("recordId") final String recordId);

}
