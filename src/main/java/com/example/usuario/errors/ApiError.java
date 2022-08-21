package com.example.usuario.errors;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ApiError {

    private int status;

    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm.ss")
    private LocalDateTime timestamp;

    private String path;

    private Map<String, String> validationErrors;

}