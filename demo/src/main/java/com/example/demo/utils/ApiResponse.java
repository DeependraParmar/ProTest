package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private Boolean status;
    private Object data;
    private String message;
    private String error;

    public ApiResponse(Boolean status, Object data, String message){
        super();
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(Boolean status, String error){
        super();
        this.status = status;
        this.error = error;
    }
}
