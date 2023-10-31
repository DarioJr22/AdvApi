package com.br.thomasvcgApi.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/*
TODO Como manipular dados no JAVa ?
TODO Como manipular tags no java  ?
TODO Como acumular dados de posts ?
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
    private Long id_post;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "subtitle",nullable = false)
    private String subtitulo;

    @Column(name = "post_date",nullable = false)
    private Date date;

    @Column(name="tags")
    private List<String> tags;

    @Column(name="article_content")
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user_id;






}
