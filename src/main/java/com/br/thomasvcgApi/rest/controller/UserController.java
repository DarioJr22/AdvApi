package com.br.thomasvcgApi.rest.controller;


import com.br.thomasvcgApi.rest.request.UserRequest;
import com.br.thomasvcgApi.rest.response.UserResponse;
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
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse response = service.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser() {
        List<UserResponse> response = service.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/{idUser}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable Long idUser) {
        UserResponse response = service.findUserById(idUser);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(value = "/{idUser}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest, @PathVariable Long idUser) {
        UserResponse response = service.updateUser(userRequest, idUser);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/{idUser}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long idUser) {
        UserResponse response = service.deleteUser(idUser);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
