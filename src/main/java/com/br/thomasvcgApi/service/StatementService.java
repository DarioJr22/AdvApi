package com.br.thomasvcgApi.service;

import com.br.thomasvcgApi.domain.entity.Statement;
import com.br.thomasvcgApi.domain.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StatementService {

    @Autowired
    StatementRepository repository;

    public Statement save(Statement c){
        return  repository.save(c);
    }

    public List<Statement> saveAll(List<Statement> cl){
        return repository.saveAll(cl);
    }

    public List<Statement> getAll(){
        return repository.findAll();
    }

    public Optional<Statement> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long cd){
        repository.deleteById(cd);
    }

    public Statement update(Statement c){
        return repository.save(c);
    }

}
