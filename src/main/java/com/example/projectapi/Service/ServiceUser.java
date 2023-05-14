package com.example.projectapi.Service;

import com.example.projectapi.Entity.User;
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
public class ServiceUser implements IServiceUser {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public Map<String,Object> createUser(User user) {

        Map<String,Object> created= new HashMap<>();

        List<User> listUser = userRepository.findAll();

    for( User u : listUser){
        if(Objects.equals(u,user)){
            created.put("created",false);
            return created;
        }
    }
    userRepository.save(user);
    created.put("created",true);
    created.put("status",HttpStatus.CREATED);
    created.put("value",HttpStatus.CREATED.value());
    return created;
    }

    @Override
    public Map<String, Object> loginAccount(String login , String password){


        Map<String,Object> verify= new HashMap<>();

        User account = userRepository.findByLogin(login);

        if(Objects.isNull(account)){
            verify.put("status",HttpStatus.NOT_FOUND);
            verify.put("value",HttpStatus.NOT_FOUND.value());
            verify.put("user",account);

        }
        else
        {
            if(account.getPassword().equals(password))
            {
                verify.put("status",HttpStatus.OK);
                verify.put("value",HttpStatus.OK.value());
                verify.put("user",account);
            }
        }
        return verify ;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {


        SimpleMailMessage message= new SimpleMailMessage();

        message.setFrom("hassenbenadel37@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);

        System.out.println("Sent!!");
    }

    @Override
    public Map<String,Object> sendCode(String email) {

        Map<String,Object> sendCode= new HashMap<>();

        User user = userRepository.findByEmail(email);


        if(Objects.isNull(user)){
            sendCode.put("value",HttpStatus.NOT_FOUND.value());
            sendCode.put("status",HttpStatus.NOT_FOUND);
        }
        else {

            String Subject="Retreive your password";
            Random random = new Random();
            Integer code = random.nextInt(1001);
            String messagecode = "your code is : " + code ;
            user.setCode(code);
            userRepository.save(user);
            sendEmail(email,Subject,messagecode);

            sendCode.put("user",user);
            sendCode.put("value",HttpStatus.OK.value());
            sendCode.put("status",HttpStatus.OK);

        }
        return sendCode;
    }

    @Override
    public Map<String, Object> verifyCode(String email, Integer code) {

        Map<String,Object> verify= new HashMap<>();

        User user = userRepository.findByEmail(email);

        Integer db_code=user.getCode();

        if(db_code.equals(code)){

            verify.put("status",HttpStatus.OK);
            verify.put("value",HttpStatus.OK.value());

        }else{
            verify.put("status",HttpStatus.NOT_FOUND);
            verify.put("value",HttpStatus.NOT_FOUND.value());
        }

        return verify;
    }

    @Override
    public Map<String, Object> modiferprofil(String email,String password,String login , String tel,Long id) {
        Map<String,Object> changed= new HashMap<>();


        User user = userRepository.findByid(id);

        if(!Objects.isNull(user))
        {
            user.setPassword(password);
            user.setLogin(login);
            user.setPhoneNumber(tel);
            user.setEmail(email);
            userRepository.save(user);
            changed.put("status",HttpStatus.OK);
            changed.put("value",HttpStatus.OK.value());

        }
        else{
            changed.put("status",HttpStatus.NOT_MODIFIED);
            changed.put("value",HttpStatus.NOT_MODIFIED.value());
        }

        return changed ;
    }

    @Override
    public ResponseEntity<Object> getApprovedUser() {

        List<User> users = userRepository.findAll();

        List<Map<String,Object>> finallistusers =new ArrayList<>();

        //List<User> list_user = new ArrayList<>();


        for (User u : users)
        {
            if(u.getApproval()){
                Map<String,Object> userMap = new HashMap<>();
                userMap.put("value",u);
                finallistusers.add(userMap);
            }
        }
        Map<String,Object> response = new HashMap<>();
        response.put("User",finallistusers);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);

    }

    @Override
    public ResponseEntity<Object> getNotApprovedUser() {
        List<User> users = userRepository.findAll();

        List<Map<String,Object>> finallistusers =new ArrayList<>();

        //List<User> list_user = new ArrayList<>();


        for (User u : users)
        {
            if(!u.getApproval()){
                Map<String,Object> userMap = new HashMap<>();
                userMap.put("value",u);
                finallistusers.add(userMap);
            }
        }
        Map<String,Object> response = new HashMap<>();
        response.put("User",finallistusers);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);

    }

    @Override
    public ResponseEntity<Object> getUser(String email) {
        User user = userRepository.findByEmail(email);
        Map<String,Object> response = new HashMap<>();
        response.put("user",user);
        response.put("value",HttpStatus.OK.value());
        response.put("status",HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);


    }

    @Override
    public ResponseEntity<Object> getUserbyId(Long idUser) {
        User user = userRepository.findById(idUser).get();
        Map<String,Object> response = new HashMap<>();
        response.put("user",user);
        response.put("value",HttpStatus.OK.value());
        response.put("status",HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @Override
    public ResponseEntity<Object> ApproveUser(String email) {
        User user = userRepository.findByEmail(email);
        Map<String,Object> response = new HashMap<>();

        if(!Objects.isNull(user)){
            user.setApproval(true);
            userRepository.save(user);
            response.put("value",HttpStatus.OK.value());
            response.put("status",HttpStatus.OK.getReasonPhrase());
        }
        else{
            response.put("value",HttpStatus.NOT_MODIFIED.value());
            response.put("status",HttpStatus.NOT_MODIFIED.getReasonPhrase());

        }


        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @Override
    public ResponseEntity<Object> DeleteUser(String email) {

        Map<String,Object> response = new HashMap<>();

        User user = userRepository.findByEmail(email);
        if(!Objects.isNull(user)){

            userRepository.delete(user);

            response.put("value",HttpStatus.OK.value());
            response.put("status",HttpStatus.OK.getReasonPhrase());

        }else{

            response.put("value",HttpStatus.NOT_FOUND.value());
            response.put("status",HttpStatus.NOT_FOUND.getReasonPhrase());

        }

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);





    }


}
