package com.example.projectapi.Service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IServiceGrandeur {

    Map<String,Object> getGrandeur();

    ResponseEntity<Object>  getAllTemperature();

    ResponseEntity<Object>  getLast5Temperature();

    ResponseEntity<Object>  getAllPh();
    ResponseEntity<Object>  getLast5Ph();

    ResponseEntity<Object>  getAllHumidity();
    ResponseEntity<Object>  getLast5Humidity();


    ResponseEntity<Object>  getAllTurbidity();
    ResponseEntity<Object>  getLast5Turbidity();


}
