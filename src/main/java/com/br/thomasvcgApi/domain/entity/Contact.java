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
    @Column(name = "id_contact")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_Content")
    private String contactContent;

    @Column(name = "arq_content")
    private String arqContent;

    @ManyToOne
    @JoinColumn(name = "id_costumer",nullable = false)
    private Costumer costumer;

}
