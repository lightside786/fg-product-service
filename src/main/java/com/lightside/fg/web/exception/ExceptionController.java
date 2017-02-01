package com.lightside.fg.web.exception;

import com.lightside.fg.exception.ApplicationException;
import com.lightside.fg.web.locale.MessageResolver;
import com.lightside.fg.web.response.ApiError;
import com.lightside.fg.web.response.ApiResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Anwar
 */

@ControllerAdvice(value = "com.lightside.fg.web.controller")
@Configurable
public class ExceptionController extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageResolver messageResolver;

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    ResponseEntity<?> handleException(ApplicationException ex) {
        logger.error("Application Exception :", ex);
        HttpStatus status = HttpStatus.BAD_REQUEST;
        if (CollectionUtils.isNotEmpty(ex.getErrors())) {
            return new ResponseEntity<>(ex.getErrors(), status);
        }
        ApiError apiError = ApiError.buildError(messageResolver.resolveMessage(ex.getErrorKey()), messageResolver.resolveMessage(ex.getMessageKey()));
        ApiResponse apiErrorResponse = new ApiResponse(apiError);
        return new ResponseEntity<>(apiErrorResponse, status);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<?> handleException(Exception ex) {
        logger.error("Generic Exception :", ex);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = ApiError.buildError(messageResolver.resolveMessage("system.error.key"),
                messageResolver.resolveMessage("system.error.message"));
        ApiResponse apiErrorResponse = new ApiResponse(apiError);
        return new ResponseEntity<>(apiErrorResponse, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = ApiError.buildError(messageResolver.resolveMessage("api.invalid.request.key"),
                messageResolver.resolveMessage("api.invalid.request.message"));
        ApiResponse apiErrorResponse = new ApiResponse(apiError);
        return new ResponseEntity<>(apiErrorResponse, status);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    ResponseEntity<?> handleException(DataIntegrityViolationException ex) {
        logger.error("Database Exception :", ex);
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ConstraintViolationException cve = (ConstraintViolationException) ex.getCause();
        String constraintName = cve.getConstraintName();
        ApiError apiError = null;
        if (StringUtils.isNotEmpty(constraintName)) {
            //TODO add product specific constraints
        } else {
            apiError = getErrorResponse("required.data.missing.key", "required.data.missing.message");
        }
        if (apiError != null) {
            ApiResponse apiErrorResponse = new ApiResponse(apiError);
            return new ResponseEntity<>(apiErrorResponse, status);
        }
        return returnDefaultSystemError(status);
    }

    private ApiError getErrorResponse(String errorCode, String errorMessage) {
        return ApiError
                .buildError(messageResolver
                                .resolveMessage(errorCode),
                        messageResolver
                                .resolveMessage(errorMessage));
    }

    private ResponseEntity<?> returnDefaultSystemError(HttpStatus status) {
        ApiError apiError = ApiError.buildError(messageResolver.resolveMessage("system.error.key"),
                messageResolver.resolveMessage("system.error.message"));
        ApiResponse apiErrorResponse = new ApiResponse(apiError);
        return new ResponseEntity<>(apiErrorResponse, status);
    }

    private ApiError getErrorResponse(ApplicationException ex) {
        return ApiError.buildError(messageResolver.resolveMessage(ex.getErrorKey()),
                messageResolver.resolveMessage(ex.getMessageKey()));
    }
}
