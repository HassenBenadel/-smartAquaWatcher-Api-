package com.example.projectapi.Service;

import com.example.projectapi.Entity.Grandeur;
import com.example.projectapi.Repository.GrandeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceGrandeur implements IServiceGrandeur{

    @Autowired
    GrandeurRepository grandeurRepository;





    @Override
    public Map<String, Object> getGrandeur() {
        Map<String,Object> grandeur = new HashMap<>();
        grandeur.put("value",grandeurRepository.findFirstByOrderByIdDesc());
        grandeur.put("status", HttpStatus.OK);
        grandeur.put("code",HttpStatus.OK.value());
        return grandeur;
    }

    @Override
    public ResponseEntity<Object> getAllTemperature() {

        List<Grandeur> list_temp=grandeurRepository.findAll();

        List<Map<String,Object>> temps = new ArrayList<>();

        for(Grandeur g : list_temp){
            Map<String,Object> tempMap = new HashMap<>();
            tempMap.put("value",g.getTemp());
            tempMap.put("heure",g.getHeure());
            temps.add(tempMap);
        }

        Map<String,Object> response = new HashMap<>();
        response.put("values",temps);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @Override
    public ResponseEntity<Object> getAllPh() {
        List<Grandeur> list_grandeur=grandeurRepository.findAll();

        List<Map<String,Object>> phs = new ArrayList<>();

        for(Grandeur g : list_grandeur){
            Map<String,Object> tempMap = new HashMap<>();
            tempMap.put("value",g.getPh());
            tempMap.put("heure",g.getHeure());
            phs.add(tempMap);
        }

        Map<String,Object> response = new HashMap<>();
        response.put("values",phs);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @Override
    public ResponseEntity<Object> getAllHumidity() {
        List<Grandeur> list_grandeur=grandeurRepository.findAll();

        List<Map<String,Object>> humidities = new ArrayList<>();

        for(Grandeur g : list_grandeur){
            Map<String,Object> tempMap = new HashMap<>();
            tempMap.put("value",g.getHumidite());
            tempMap.put("heure",g.getHeure());
            humidities.add(tempMap);
        }

        Map<String,Object> response = new HashMap<>();
        response.put("values",humidities);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @Override
    public ResponseEntity<Object> getAllTurbidity() {
        List<Grandeur> list_grandeur=grandeurRepository.findAll();

        List<Map<String,Object>> turbidities = new ArrayList<>();

        for(Grandeur g : list_grandeur){
            Map<String,Object> tempMap = new HashMap<>();
            tempMap.put("value",g.getTurbidite());
            tempMap.put("heure",g.getHeure());
            turbidities.add(tempMap);
        }

        Map<String,Object> response = new HashMap<>();
        response.put("values",turbidities);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);    }
}
