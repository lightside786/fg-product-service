package com.lightside.fg.web.response.dto;

import lombok.Getter;

/**
 * @author anwar
 */

@Getter
public class ProductDTO {
    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
