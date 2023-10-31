package com.br.thomasvcgApi.repository;

import com.br.thomasvcgApi.domain.entity.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository <Statement,Long> {
}
