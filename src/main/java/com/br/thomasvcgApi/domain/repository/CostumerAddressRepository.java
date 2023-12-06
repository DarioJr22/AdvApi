package com.br.thomasvcgApi.domain.repository;

import com.br.thomasvcgApi.domain.entity.CostumerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerAddressRepository extends JpaRepository<CostumerAddress, Long> {
}
