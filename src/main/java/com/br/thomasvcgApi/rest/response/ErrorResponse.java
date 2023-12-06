package com.br.thomasvcgApi.rest.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String msg;
    private String error;
    private HttpStatus status;

    public ErrorResponse(String msg, String error, HttpStatus status) {
        this();
        this.msg = msg;
        this.error = error;
        this.status = status;
    }
    public ErrorResponse() {
        timestamp = LocalDateTime.now();
    }
}
