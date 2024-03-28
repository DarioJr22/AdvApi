package com.br.thomasvcgApi.domain.repository;

import com.br.thomasvcgApi.domain.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {



    Post findByTitle(String title);
}
