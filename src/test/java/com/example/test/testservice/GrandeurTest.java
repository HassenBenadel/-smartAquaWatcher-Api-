package com.example.test.testservice;

import com.example.projectapi.Entity.User;
import com.example.projectapi.ProjectApiApplication;
import com.example.projectapi.Service.IServiceGrandeur;
import com.example.projectapi.Service.IServiceUser;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = ProjectApiApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GrandeurTest {

    @Autowired
    IServiceGrandeur isg ;

    @Test
    @Order(1)
    public void testRetreiveGrandeurs(){
        Map<String,Object> listgrandeurs = isg.getGrandeur();
        Assertions.assertEquals(3, listgrandeurs.size());
    }


}

