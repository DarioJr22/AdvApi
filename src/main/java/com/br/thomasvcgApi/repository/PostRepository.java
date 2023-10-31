package com.br.thomasvcgApi.repository;

import com.br.thomasvcgApi.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
