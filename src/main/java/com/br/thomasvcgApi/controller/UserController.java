package com.br.thomasvcgApi.controller;


import com.br.thomasvcgApi.domain.dto.request.UserDTO;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping
    public UserDTO putUser(@RequestBody UserDTO user){
        return service.update(user);
    }


}
