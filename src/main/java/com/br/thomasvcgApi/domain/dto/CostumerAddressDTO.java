package com.br.thomasvcgApi.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CostumerAddressDTO(
             Long id,
             String street,
             String district,
             String cep,
             int number,
             String complement,
             String city,
             String uf
) {
}
