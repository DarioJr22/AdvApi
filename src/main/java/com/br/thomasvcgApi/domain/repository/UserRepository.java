package com.br.thomasvcgApi.domain.repository;

import com.br.thomasvcgApi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
