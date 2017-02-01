package com.lightside.fg.web.response.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * @author anwar
 */

@Getter
@ToString
public class ProductCategoryDTO {

    private String id;
    private String name;
    private String description;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
