package com.lightside.fg.exception;

import com.lightside.fg.web.response.ApiError;
import lombok.*;

import java.util.Collection;

/**
 * @author Anwar
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ApplicationException extends RuntimeException {

    private Collection<ApiError> errors;
    private String errorKey;
    private String messageKey;

    public ApplicationException(String errorKey, String messageKey) {
        this.errorKey = errorKey;
        this.messageKey = messageKey;
    }

    public ApplicationException(String errorKey) {
        this.errorKey = errorKey;
    }

    public ApplicationException(Collection<ApiError> errors) {
        this.errors = errors;
    }
}
