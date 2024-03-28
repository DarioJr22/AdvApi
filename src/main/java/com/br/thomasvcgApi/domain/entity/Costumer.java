package com.br.thomasvcgApi.domain.entity;


import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import com.br.thomasvcgApi.rest.request.CostumerRequest;
import com.br.thomasvcgApi.util.Relationship;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @JsonIgnore
    @OneToMany(mappedBy = "costumer")
    private List<Statement> statements;

    @JsonIgnore
    @OneToMany(mappedBy = "costumer")
    private List<Contact> contacts;

    public Costumer(CostumerRequest request) {
        this.costumerName = request.costumerName();
        this.relationship = request.relationship();
        this.email = request.costumerName();
        this.contact = request.contact();
        this.birthday = request.birthday();
        this.rg = request.rg();
        this.cpf = request.cpf();
        this.address = new CostumerAddress();
        this.user = new User();
        this.statements = new ArrayList<>();
        this.contacts = new ArrayList<>();
    }

}
