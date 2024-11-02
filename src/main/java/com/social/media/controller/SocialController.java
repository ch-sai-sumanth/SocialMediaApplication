package com.social.media.controller;

import com.social.media.model.SocialUser;
import com.social.media.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {

    @Autowired
    SocialService socialService;

    @GetMapping("social/users")
    public ResponseEntity<List<SocialUser>> getAllUsers(){
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("social/users")
    public ResponseEntity<SocialUser> addUser(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialService.addUser(socialUser),HttpStatus.OK);
    }

    @DeleteMapping("social/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
         socialService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Succesfully",HttpStatus.OK);
    }
}
