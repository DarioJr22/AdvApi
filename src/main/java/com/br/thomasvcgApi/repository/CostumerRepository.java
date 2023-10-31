package com.br.thomasvcgApi.repository;

import com.br.thomasvcgApi.domain.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer,Long> {
}
