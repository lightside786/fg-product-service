package com.lightside.fg.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the TAGS database table.
 */
@Entity
@Table(name = "TAGS")
@Setter
@ToString(exclude = "productTags")
@EqualsAndHashCode(of = {"tag"})
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_id")
    private String recordId;

    private String tag;

    //bi-directional many-to-one association to ProductTag
    @OneToMany(mappedBy = "tag")
    private Set<ProductTag> productTags;

    public Tag() {
    }

    public ProductTag addProductTag(ProductTag productTag) {
        getProductTags().add(productTag);
        productTag.setTag(this);

        return productTag;
    }

    public ProductTag removeProductTag(ProductTag productTag) {
        getProductTags().remove(productTag);
        productTag.setTag(null);
        return productTag;
    }

    public Long getId() {
        return id;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getTag() {
        return tag;
    }

    public Set<ProductTag> getProductTags() {
        return productTags;
    }
}