package com.br.thomasvcgApi.rest.request;

import com.br.thomasvcgApi.domain.dto.CostumerAddressDTO;
import com.br.thomasvcgApi.util.Relationship;

import java.util.Date;

public record CostumerRequest(
       String costumerName,
       Relationship relationship,
       String email,
       String contact,
       Date birtday,
       String rg,
       String cpf,
       CostumerAddressDTO address,
       Long idUser
) {
}
