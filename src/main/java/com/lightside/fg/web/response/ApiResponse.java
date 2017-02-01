package com.lightside.fg.web.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.*;

/**
 * @author Anwar
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ApiResponse {

    private boolean valid;
    private Collection<ApiError> errors = Collections.emptyList();

    public ApiResponse(int size) {
        this.errors = new ArrayList<>(size);
    }

    public ApiResponse(ApiError apiError) {
        initErrors();
        errors.add(apiError);
    }

    public ApiResponse(Collection<ApiError> errors) {
        this.errors = errors;
    }

    @JsonIgnore
    public void addError(ApiError apiError) {
        initErrors();
        errors.add(apiError);
    }

    private void initErrors() {
        if (errors.isEmpty()) {
            errors = new ArrayList<>();
        }
    }
}
