package com.lightside.fg.web.response.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author anwar
 */

@Getter
@EqualsAndHashCode(of = "id")
public class ProductPriceDTO {
    private String id;
    private String price;
    private String priceUnit;
    private String currency;
    private String effEndDate;
    private String effStartDate;
    private String createdOn;
    private String updatedOn;

    public void setId(String id) {
        this.id = id;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setEffEndDate(String effEndDate) {
        this.effEndDate = effEndDate;
    }

    public void setEffStartDate(String effStartDate) {
        this.effStartDate = effStartDate;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
}
