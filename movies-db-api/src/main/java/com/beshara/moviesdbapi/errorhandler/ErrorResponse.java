package com.beshara.moviesdbapi.errorhandler;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class ErrorResponse {
    private final int status;
    private final String message;
    private final long timestamp;
    private final String stackTrace;

    public ErrorResponse(HttpStatus status, Exception exception) {
        this.status = status.value();
        this.message = exception.getMessage();
        this.timestamp = System.currentTimeMillis();
        this.stackTrace = Arrays.toString(exception.getStackTrace());
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getStackTrace() {
        return stackTrace;
    }
}
