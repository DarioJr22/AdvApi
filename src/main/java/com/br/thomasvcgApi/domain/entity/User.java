package com.br.thomasvcgApi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


/*
TODO Verificar a possibilidade dessa tabela ter uma instância fire base
TODO Fazer relacionamentos exter

 */


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_seq")
    @Column(name = "cd_user",unique = true,nullable = false)
    private Long id_user;

    @Column(name="login",nullable = false)
    private String login;

    @Column(name="password",length = 50,nullable = false)
    private String password;

    @Column(name="email",length = 120)
    private String email;

    @OneToMany(mappedBy = "user_id")
    private List<Post> postList = new ArrayList<Post>();

    @OneToMany(mappedBy ="user_id")
    private List<Costumer>  costumerList = new ArrayList<>();
}
