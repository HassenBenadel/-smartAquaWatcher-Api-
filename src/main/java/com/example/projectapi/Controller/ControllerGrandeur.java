package com.example.projectapi.Controller;

import com.example.projectapi.Entity.User;
import com.example.projectapi.Repository.GrandeurRepository;
import com.example.projectapi.Service.IServiceGrandeur;
import com.example.projectapi.Service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ControllerGrandeur {

    @Autowired
    IServiceGrandeur iServiceGrandeur;

    @GetMapping("/GetAllTemperature")
    public  ResponseEntity<Object> getTemperature(){
        return iServiceGrandeur.getAllTemperature();
    }
    @GetMapping("/GetAllHumidity")
    public  ResponseEntity<Object> getHumidity(){
        return iServiceGrandeur.getAllHumidity();
    }
    @GetMapping("/GetAllPh")
    public  ResponseEntity<Object> getPh(){
        return iServiceGrandeur.getAllPh();
    }
    @GetMapping("/GetAllTurbidity")
    public  ResponseEntity<Object> getTurbidity(){
        return iServiceGrandeur.getAllTurbidity();
    }

    @GetMapping("/GetGrandeur")
    public Map<String, Object> getGrandeur(){
        return iServiceGrandeur.getGrandeur();
    }






}
