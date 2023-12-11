package com.br.thomasvcgApi.domain.entity;


import com.br.thomasvcgApi.util.Relationship;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="costumer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_costumer")
    private Long id;

    @Column(name="costumer_name",nullable = false)
    private String costumerName;

    @Column(name="relationship")
    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    @Column(name = "email")
    private String email;

    @Column(name="contact")
    private String contact;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_address")
    private CostumerAddress address;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @OneToMany(mappedBy = "costumer")
    private List<Statement> statements;

    @OneToMany(mappedBy = "costumer")
    private List<Contact> contacts;

}
