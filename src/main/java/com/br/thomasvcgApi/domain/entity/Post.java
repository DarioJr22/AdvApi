package com.br.thomasvcgApi.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/*
TODO Como manipular dados no JAVa ?
TODO Como manipular tags no java  ?
TODO Como acumular dados de posts ?
TODO CRIAR A CLASS FILEtXT NO LUGAR DO CONTEUDO
 */

@Entity
@Table(name="post")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {

    @Id
    @Column(name="id_post")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "subtitle",nullable = false)
    private String subtitle;

    @Column(name = "post_date",nullable = false)
    private LocalDate date;

    @ElementCollection
    @CollectionTable(name = "post_tags",joinColumns = @JoinColumn(name = "id_post"))
    private List<String> tags;

    @Lob
    @Column(name="content_base64",columnDefinition = "LONGTEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
}
