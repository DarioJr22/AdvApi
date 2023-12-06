package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.exception.handler.HandlerError;
import com.br.thomasvcgApi.rest.request.UserRequest;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.domain.repository.UserRepository;
import com.br.thomasvcgApi.rest.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserResponse save(UserRequest userRequest){

        try {
            User user = new User();
            user.setLogin(userRequest.login());
            user.setPassword(userRequest.password());
            user.setEmail(userRequest.email());
            user.setRole(userRequest.role());
            userRepository.save(user);

            return new UserResponse("User created successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }

    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void delete(Long cd) {
        userRepository.deleteById(cd);
    }
    public User update(User c){
        return userRepository.save(c);
    }

}
