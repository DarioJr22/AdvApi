package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.dto.request.UserDTO;
import com.br.thomasvcgApi.domain.entity.Post;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.repository.PostRepository;
import com.br.thomasvcgApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User save(User c){
        return  repository.save(c);
    }

    public List<User> saveAll(List<User> cl){
        return repository.saveAll(cl);
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long cd) {
        repository.deleteById(cd);
    }
    public User update(User c){
        return repository.save(c);
    }

}
