package com.br.thomasvcgApi.domain.dto;

import com.br.thomasvcgApi.util.Relationship;
import lombok.Builder;

import java.util.Date;
@Builder
public record CostumerDTO(
            Long id,
            String costumerName,
            Relationship relationship,
            String email,
            String contact,
            Date birtday,
            String rg,
            String cpf,
            CostumerAddressDTO address,
            UserDTO user
) {
}
