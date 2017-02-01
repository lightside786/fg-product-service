package com.lightside.fg.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the PRODUCT_IMAGES database table.
 */
@Entity
@Table(name = "PRODUCT_IMAGES")
@ToString(exclude = "product")
@Setter
@EqualsAndHashCode(of = "url")
public class ProductImage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "record_id")
    private String recordId;

    private String url;

    //bi-directional many-to-one association to Product
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public ProductImage() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getUrl() {
        return url;
    }

    public Product getProduct() {
        return product;
    }
}
