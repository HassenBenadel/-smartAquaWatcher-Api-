package com.example.projectapi.Service;

import com.example.projectapi.Entity.Barage;
import com.example.projectapi.Entity.User;
import com.example.projectapi.Repository.BarageRepository;
import com.example.projectapi.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ServiceBarage implements IServiceBarage {

    @Autowired
    BarageRepository barageRepository;


    @Override
    public ResponseEntity<Object> getAllBarage() {


        List<Barage> barages = barageRepository.findAll();

        //List<Map<String,Object>> response =new ArrayList<>();


        Map<String,Object> response = new HashMap<>();
        response.put("Barage",barages);
        response.put("value",HttpStatus.OK.value());
        response.put("value",HttpStatus.OK.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
