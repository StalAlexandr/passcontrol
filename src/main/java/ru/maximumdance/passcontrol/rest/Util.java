package ru.maximumdance.passcontrol.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

    static <T> ResponseEntity<T> buildPersonResponseEntity(T body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (body != null) {
            return new ResponseEntity<>(
                    body, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(
                body, headers, HttpStatus.NOT_FOUND);
    }
}
