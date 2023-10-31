package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.entity.Contact;
import com.br.thomasvcgApi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;

    public Contact save(Contact c){
        return  repository.save(c);
    }

    public List<Contact> saveAll(List<Contact> cl){
        return repository.saveAll(cl);
    }

    public List<Contact> getAll(){
        return repository.findAll();
    }

    public Optional<Contact> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long cd){
        repository.deleteById(cd);
    }

    public Contact update(Contact c){
        return repository.save(c);
    }





}
