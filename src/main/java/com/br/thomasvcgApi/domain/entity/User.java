package com.br.thomasvcgApi.domain.entity;

import com.br.thomasvcgApi.util.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/*
TODO Verificar a possibilidade dessa tabela ter uma instância fire base
TODO Fazer relacionamentos exter
 */
@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user",unique = true,nullable = false)
    private Long id;

    @Column(name="login",nullable = false)
    private String login;

    @Column(name="password",length = 50,nullable = false)
    private String password;

    @Column(name="email",length = 120)
    private String email;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy ="user")
    private List<Costumer>  costumers;
}
