package com.example.projectapi.Controller;

import com.example.projectapi.Entity.User;
import com.example.projectapi.Service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ControllerUser {

    @Autowired
    IServiceUser ise ;

    @GetMapping("/VerifyLogin/Login={l}/Password={p}")
    public Map<String, Object> VerifyLogin(@PathVariable("l") String login , @PathVariable("p") String password){
    return ise.loginAccount(login, password);
    }

    @PostMapping("/createUser")
    public Map<String,Object>createUser(@RequestBody User u ){
        return ise.createUser(u);
    }

    @GetMapping("sendCode/email={email}")
    public Map<String,Object> sendCode(@PathVariable("email") String email) {
        return ise.sendCode(email);
    }

    @GetMapping("verifyCode={code}/email={email}")
    public Map<String,Object> verifyCode(@PathVariable("email") String email,@PathVariable("code") Integer code) {
        return ise.verifyCode(email, code);
    }

    @PutMapping("updatePassword/Email={email}/password={password}")
    public Map<String,Object> updatePassword(@PathVariable("email") String email,@PathVariable("password") String password) {
        return ise.updatePassword(email, password);
    }


    @PutMapping("SetApproval/Email={email}")
    public ResponseEntity<Object> ApproveUser(@PathVariable("email") String email) {
        return  ise.ApproveUser(email);
    }

    @GetMapping("/GetApprovedUser")
    public  ResponseEntity<Object> getApprovedUser(){
        return ise.getApprovedUser();
    }


    @GetMapping("/GetNotApprovedUser")
    public  ResponseEntity<Object> getNotApprovedUser(){
        return ise.getNotApprovedUser();
    }


    @GetMapping("/GetuserByEmail={email}")
    public  ResponseEntity<Object> getuserbyEmail(@PathVariable("email") String email){
        return ise.getUser(email);
    }

    @DeleteMapping("/deleteUser/Email={email}")
    public  ResponseEntity<Object> DeleteUserByEmail(@PathVariable("email") String email){
        return ise.DeleteUser(email);
    }





    }
