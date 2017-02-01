package com.lightside.fg.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author anwar
 */

@Entity
@Table(name = "PRODUCT_TAGS")
@ToString(exclude = "product")
@Setter
@EqualsAndHashCode(of = {"product", "tag"})
public class ProductTag implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_id")
    private String recordId;

    //bi-directional many-to-one association to Product
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    //bi-directional many-to-one association to Tag
    @ManyToOne(fetch = FetchType.LAZY)
    private Tag tag;

    public ProductTag() {
    }

    public Long getId() {
        return id;
    }

    public String getRecordId() {
        return recordId;
    }

    public Product getProduct() {
        return product;
    }

    public Tag getTag() {
        return tag;
    }
}
