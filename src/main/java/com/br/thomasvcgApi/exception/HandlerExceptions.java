package com.br.thomasvcgApi.exception;


import com.br.thomasvcgApi.exception.handler.HandlerEntityNotFoundException;
import com.br.thomasvcgApi.exception.handler.HandlerError;
import com.br.thomasvcgApi.rest.response.ErrorResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j(topic = "HANDLER_EXCEPTIONS")
public class HandlerExceptions extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        logError(ex);
        log.error("HTTP method not supported review the method");
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),"Method not valid",HttpStatus.BAD_REQUEST);
        return handleExceptionInternal(ex, errorResponse,headers,HttpStatus.BAD_REQUEST,request);
    }
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        logError(ex);
        log.error("error in the request check its formatting");
        Object message= null;
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException exception = (InvalidFormatException) ex.getCause();
            message = exception.getValue();
        }
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),"Invalid format",HttpStatus.BAD_REQUEST);
        return handleExceptionInternal(ex, errorResponse,headers,HttpStatus.BAD_REQUEST,request);
    }
    @ExceptionHandler(HandlerEntityNotFoundException.class)
    public ResponseEntity<Object> handlerEntityNotFoundExecption(HandlerEntityNotFoundException ex){
        logError(ex);
        log.error("Entity does not exist or cannot be found, check the entity inserted");
        return buildResponseError(ex.getMessage(),"Entity not found",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(HandlerError.class)
    public ResponseEntity<Object> handlerError(HandlerError ex){
        logError(ex);
        log.error("some error was found in the api");
        return buildResponseError(ex.getMessage(),"API error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionGeneric(Exception ex){
        logError(ex);
        log.error("some error was found in the api");
        return buildResponseError(ex.getMessage(),"API error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private static void logError(Exception ex){
        log.error(ex.getClass().getName(), ex);
        log.error(ex.getClass().getName(), ex.getMessage());
        log.error(ex.getClass().getName(), ex.getLocalizedMessage());
    }
    private ResponseEntity<Object> buildResponseError(String msg, String error,HttpStatus status){
        ErrorResponse errorResponse = new ErrorResponse(msg,error,status);
        return ResponseEntity.status(status).body(errorResponse);
    }


}
