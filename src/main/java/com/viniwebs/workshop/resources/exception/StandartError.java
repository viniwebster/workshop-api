package com.viniwebs.workshop.resources.exception;

import java.time.Instant;

public class StandartError {
    private Instant timestamp;
    private Integer status;
    private String message;
    private String error;
    private String path;

    public StandartError(Instant timestamp, String error, Integer status, String message, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
