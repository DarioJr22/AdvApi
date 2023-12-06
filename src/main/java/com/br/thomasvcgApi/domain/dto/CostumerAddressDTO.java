package com.br.thomasvcgApi.domain.dto;

import lombok.Builder;

@Builder
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
