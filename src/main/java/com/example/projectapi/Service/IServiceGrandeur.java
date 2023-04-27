package com.example.projectapi.Service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IServiceGrandeur {

    Map<String,Object> getGrandeur();

    ResponseEntity<Object>  getAllTemperature();
    ResponseEntity<Object>  getAllPh();
    ResponseEntity<Object>  getAllHumidity();
    ResponseEntity<Object>  getAllTurbidity();
}
