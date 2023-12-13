package com.br.thomasvcgApi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="statement")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statement")
    private Long id;

    @Column(name="statement_content")
    private String statementContent;

    @Column(name="arq_content")
    private String arqContent;

    @Column(name="statement_description")
    private String statementDescription;

    @Column(name="statement_amount")
    private Double statementAmount;

    @Column(name="statement_date")
    private LocalDate statementDate;

    @ManyToOne
    @JoinColumn(name = "id_costumer",nullable = false)
    private Costumer costumer;
}
