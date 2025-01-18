package org.zahin.DrivingSpotter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime timestamp;
    protected HttpStatus status;
    protected int statusCode;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data;
}
