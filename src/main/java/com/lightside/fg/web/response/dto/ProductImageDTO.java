package com.lightside.fg.web.response.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author anwar
 */

@Getter
@EqualsAndHashCode(of = "id")
public class ProductImageDTO {

    private String id;
    private String description;
    private String url;

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
