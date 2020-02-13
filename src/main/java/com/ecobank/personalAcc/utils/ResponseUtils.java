package com.ecobank.personalAcc.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecobank.personalAcc.dto.Response;


@Service
public class ResponseUtils {
	public ResponseEntity<Response> getResponse(String code, String message, Object customerAccountList) {
        Response response = new Response();
        response.setResponseCode(code);
        response.setResponseMessage(message);
        response.setResponseData(customerAccountList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity<Response> getResponse(String code, String message) {
        Response response = new Response();
        response.setResponseCode(code);
        response.setResponseMessage(message);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
