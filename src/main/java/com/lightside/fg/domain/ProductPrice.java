package com.lightside.fg.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "PRODUCT_PRICE")
@ToString(exclude = "product")
@Setter
@EqualsAndHashCode(of = {"product", "effStartDate"})
public class ProductPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on")
    private Timestamp createdOn;

    private String currency;

    @Column(name = "eff_end_date")
    private Timestamp effEndDate;

    @Column(name = "eff_start_date")
    private Timestamp effStartDate;

    private BigDecimal price;

    @Column(name = "price_unit")
    @Enumerated(EnumType.STRING)
    private UnitOfMeasure priceUnit;

    @Column(name = "record_id")
    private String recordId;

    @Column(name = "updated_on")
    private Timestamp updatedOn;

    //bi-directional many-to-one association to Product
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public ProductPrice() {
    }

    public Long getId() {
        return id;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public String getCurrency() {
        return currency;
    }

    public Timestamp getEffEndDate() {
        return effEndDate;
    }

    public Timestamp getEffStartDate() {
        return effStartDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public UnitOfMeasure getPriceUnit() {
        return priceUnit;
    }

    public String getRecordId() {
        return recordId;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public Product getProduct() {
        return product;
    }
}