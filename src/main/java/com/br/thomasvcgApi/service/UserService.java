package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.rest.request.UserRequest;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(UserRequest userRequest){
        User user = new User();
        user.setLogin(userRequest.login());
        user.setPassword(userRequest.password());
        user.setEmail(userRequest.email());
        return  userRepository.save(user);
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
