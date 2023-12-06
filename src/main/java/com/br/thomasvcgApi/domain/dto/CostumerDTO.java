package com.br.thomasvcgApi.domain.dto;

import com.br.thomasvcgApi.util.Relationship;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public record CostumerDTO(
            Long id,
            String costumerName,
            Relationship relationship,
            String email,
            String contact,
            @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
            LocalDate birtday,
            String rg,
            String cpf,
            CostumerAddressDTO address,
            UserDTO user
) {
}
