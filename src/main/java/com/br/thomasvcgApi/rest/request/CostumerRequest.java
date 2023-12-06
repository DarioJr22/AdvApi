package com.br.thomasvcgApi.rest.request;

import com.br.thomasvcgApi.domain.dto.CostumerAddressDTO;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.util.Relationship;

import java.time.LocalDate;

public record CostumerRequest(
       String costumerName,
       Relationship relationship,
       String email,
       String contact,
       LocalDate birtday,
       String rg,
       String cpf,
       CostumerAddressDTO address,
       User user
) {
}
