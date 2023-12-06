package com.br.thomasvcgApi.rest.controller;


import com.br.thomasvcgApi.rest.request.UserRequest;
import com.br.thomasvcgApi.rest.response.UserResponse;
import com.br.thomasvcgApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse response = service.save(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
