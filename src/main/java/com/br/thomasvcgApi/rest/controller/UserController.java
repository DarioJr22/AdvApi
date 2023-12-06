package com.br.thomasvcgApi.rest.controller;


import com.br.thomasvcgApi.rest.request.UserRequest;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
    UserService service;

    @GetMapping
    public List<User> findAll(){
        return service.getAll();
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){
        User response = service.save(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
//    @PutMapping
//    public User putUser(@RequestBody UserDTO user){
//        return service.update(user);
//    }


}
