package com.lightside.fg.web.response.dto;

import lombok.Getter;

import java.util.Collection;

/**
 * @author anwar
 */

@Getter
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private String status;
    private ProductCategoryDTO productCategory;
    private Collection<ProductImageDTO> productImages;
    private Collection<ProductPriceDTO> productPrices;
    private String createdOn;
    private String updatedOn;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setProductCategory(ProductCategoryDTO productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductImages(Collection<ProductImageDTO> productImages) {
        this.productImages = productImages;
    }

    public void setProductPrices(Collection<ProductPriceDTO> productPrices) {
        this.productPrices = productPrices;
    }
}
