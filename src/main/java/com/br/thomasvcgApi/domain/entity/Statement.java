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
    @Column(name = "id")
    private Long id;

    @Column(name="statement_content")
    private String statement_content;

    @Column(name="arq_content")
    private String arq_content;

    @ManyToOne
    @JoinColumn(name = "costumer_id",nullable = false)
    private Costumer costumer_id;
}
