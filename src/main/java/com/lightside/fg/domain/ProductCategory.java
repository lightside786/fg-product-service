package com.lightside.fg.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the PRODUCT_CATEGORY database table.
 */
@Entity
@Table(name = "PRODUCT_CATEGORY")
@ToString(exclude = "products")
@Setter
@EqualsAndHashCode(of = "name")
public class ProductCategory implements Serializable {
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

    private String status;

    @Column(name = "updated_on")
    private Timestamp updatedOn;

    //bi-directional many-to-one association to Product
    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;

    public ProductCategory() {
    }

    public Product addProduct(Product product) {
        getProducts().add(product);
        product.setProductCategory(this);

        return product;
    }

    public Product removeProduct(Product product) {
        getProducts().remove(product);
        product.setProductCategory(null);
        return product;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
