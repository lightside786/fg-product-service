package com.lightside.fg.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * The persistent class for the PRODUCTS database table.
 */
@Entity
@Table(name = "PRODUCTS")
@ToString
@Setter
@EqualsAndHashCode(of = "name")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    private Timestamp createdOn;

    private String description;

    private String name;

    @Column(name = "record_id")
    private String recordId;

    @Enumerated(EnumType.STRING)
    private RecordStatus status;

    @Column(name = "updated_on")
    private Timestamp updatedOn;

    //bi-directional many-to-one association to ProductCategory
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;

    //bi-directional many-to-one association to ProductImage
    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages;

    //bi-directional many-to-one association to ProductPrice
    @OneToMany(mappedBy = "product")
    private Set<ProductPrice> productPrices;

    //bi-directional many-to-one association to ProductTag
    @OneToMany(mappedBy = "product")
    private Set<ProductTag> productTags;

    public Product() {
    }

    public ProductImage addProductImage(ProductImage productImage) {
        getProductImages().add(productImage);
        productImage.setProduct(this);

        return productImage;
    }

    public ProductImage removeProductImage(ProductImage productImage) {
        getProductImages().remove(productImage);
        productImage.setProduct(null);

        return productImage;
    }

    public ProductPrice addProductPrice(ProductPrice productPrice) {
        getProductPrices().add(productPrice);
        productPrice.setProduct(this);

        return productPrice;
    }

    public ProductPrice removeProductPrice(ProductPrice productPrice) {
        getProductPrices().remove(productPrice);
        productPrice.setProduct(null);

        return productPrice;
    }

    public ProductTag addProductTag(ProductTag productTag) {
        getProductTags().add(productTag);
        productTag.setProduct(this);

        return productTag;
    }

    public ProductTag removeProductTag(ProductTag productTag) {
        getProductTags().remove(productTag);
        productTag.setProduct(null);

        return productTag;
    }

    public Set<ProductImage> getProductImages() {
        if (productImages == null) {
            productImages = new HashSet<>(5);
        }
        return productImages;
    }

    public Set<ProductPrice> getProductPrices() {
        if (productPrices == null) {
            productPrices = new HashSet<>(5);
        }
        return productPrices;
    }

    public Set<ProductTag> getProductTags() {
        if (productTags == null) {
            productTags = new HashSet<>(5);
        }
        return productTags;
    }

    public Long getId() {
        return this.id;
    }

    public Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public RecordStatus getStatus() {
        return this.status;
    }

    public Timestamp getUpdatedOn() {
        return this.updatedOn;
    }

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

}
