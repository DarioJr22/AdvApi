package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.entity.Costumer;
import com.br.thomasvcgApi.domain.entity.Post;
import com.br.thomasvcgApi.repository.CostumerRepository;
import com.br.thomasvcgApi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository repository;

    public Post save(Post c){
        return  repository.save(c);
    }

    public List<Post> saveAll(List<Post> cl){
        return repository.saveAll(cl);
    }

    public List<Post> getAll(){
        return repository.findAll();
    }

    public Optional<Post> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long cd){
        repository.deleteById(cd);
    }

    public Post update(Post c){
        return repository.save(c);
    }

}
