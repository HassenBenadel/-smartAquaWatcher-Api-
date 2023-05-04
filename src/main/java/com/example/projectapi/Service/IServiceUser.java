package com.example.projectapi.Service;

import com.example.projectapi.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IServiceUser {

     Map<String,Object> createUser(User user);
     Map<String, Object> loginAccount(String login , String password);
     void sendEmail(String to , String subject , String body);
     Map<String,Object> sendCode(String email );
     Map<String, Object> verifyCode(String email , Integer code );
     Map<String, Object> updatePassword(String email,String password);

     ResponseEntity<Object> getApprovedUser();

     ResponseEntity<Object> getNotApprovedUser();

     ResponseEntity<Object> getUser(String email);
     ResponseEntity<Object> getUserbyId(Long idUser);

     ResponseEntity<Object> ApproveUser(String email);

     ResponseEntity<Object> DeleteUser(String email);








}







