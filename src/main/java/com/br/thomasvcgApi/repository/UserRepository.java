package com.br.thomasvcgApi.repository;

import com.br.thomasvcgApi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
