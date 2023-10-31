package com.br.thomasvcgApi.domain.entity;


import com.br.thomasvcgApi.util.Relationship;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="costumer")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id_costumer;

    @Column(name="costumer_name",nullable = false)
    private String costumer_name;


    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    @Column(name = "email")
    private String email;

    @Column(name="contact")
    private String contact;

    @Column(name = "birthday")
    private Date birtday;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Embedded
    private CostumerAddress adress;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;

    @OneToMany(mappedBy = "statement_id")
    private List<Statement> statement_id = new ArrayList<>();

    @OneToMany(mappedBy = "contact_id")
    private List<Contact> contact_id = new ArrayList<>();



}
