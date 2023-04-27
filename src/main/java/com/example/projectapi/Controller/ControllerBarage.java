package com.example.projectapi.Controller;

import com.example.projectapi.Service.IServiceBarage;
import com.example.projectapi.Service.IServiceGrandeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ControllerBarage {

    @Autowired
    IServiceBarage iServiceBarage;

    @GetMapping("/GetAllBarage")
    public ResponseEntity<Object> getGrandeur(){
        return iServiceBarage.getAllBarage();
    }






}
