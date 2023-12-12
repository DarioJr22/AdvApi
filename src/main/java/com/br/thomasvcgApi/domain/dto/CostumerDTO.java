package com.br.thomasvcgApi.domain.dto;

import com.br.thomasvcgApi.util.Relationship;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDate;
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CostumerDTO(
            Long id,
            String costumerName,
            Relationship relationship,
            String email,
            String contact,
            @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
            LocalDate birthday,
            String rg,
            String cpf,
            CostumerAddressDTO address,
            UserDTO user
) {
}
