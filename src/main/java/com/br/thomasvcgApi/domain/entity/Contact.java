package com.br.thomasvcgApi.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contact")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact  {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String contact_content;

    @Column
    private String arq_content;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Costumer client_id;


}
