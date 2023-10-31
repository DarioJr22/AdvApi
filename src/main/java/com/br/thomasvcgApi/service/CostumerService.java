package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.entity.Contact;
import com.br.thomasvcgApi.domain.entity.Costumer;
import com.br.thomasvcgApi.repository.ContactRepository;
import com.br.thomasvcgApi.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    CostumerRepository repository;

    public Costumer save(Costumer c){
        return  repository.save(c);
    }

    public List<Costumer> saveAll(List<Costumer> cl){
        return repository.saveAll(cl);
    }

    public List<Costumer> getAll(){
        return repository.findAll();
    }

    public Optional<Costumer> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long cd){
        repository.deleteById(cd);
    }

    public Costumer update(Costumer c){
        return repository.save(c);
    }

}
