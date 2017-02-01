package com.lightside.fg.web.exception;

import com.lightside.fg.web.locale.MessageResolver;
import com.lightside.fg.web.response.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

/**
 * @author Anwar
 */

@Component
@Slf4j
public class ErrorReporter {

    private MessageResolver messageResolver;

    public ErrorReporter(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public List<ApiError> createErrors(final BindingResult bindingResult) {
        final List<ApiError> errors = new ArrayList<>(bindingResult.getFieldErrorCount());
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            //TODO Anwar find ways to optimize this
            String errorKey = fieldError.getDefaultMessage() + ".key";
            String errorMessageKey = fieldError.getDefaultMessage() + ".message";
            errors.add(ApiError.buildError(messageResolver.resolveMessage(errorKey), messageResolver.resolveMessage(errorMessageKey)));
        }
        Collections.sort(errors);
        log.debug("Errors reported : {}", errors);
        return errors;
    }
}
