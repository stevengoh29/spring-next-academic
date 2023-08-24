package com.stevengoh.academic.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Service
public class CustomResponse<T> {
    private Integer responseCode;
    private String message;
    private T data;

    public CustomResponse<List<?>> setCustomResponse (Integer responseCode, String message, List<?> data) {
        CustomResponse<List<?>> response = new CustomResponse<>();
        response.setResponseCode(responseCode);
        response.setMessage(message);
        response.setData(data);

        return response;
    }

    public CustomResponse<String> setCustomResponse (Integer responseCode, String message) {
        CustomResponse<String> response = new CustomResponse<String>();
        response.setResponseCode(responseCode);
        response.setMessage(message);
        response.setData(null);

        return response;
    }

    public CustomResponse<Object> setCustomResponse (Integer responseCode, String message, Object data) {
        CustomResponse<Object> response = new CustomResponse<Object>();
        response.setResponseCode(responseCode);
        response.setMessage(message);
        response.setData(data);

        return response;
    }
}
