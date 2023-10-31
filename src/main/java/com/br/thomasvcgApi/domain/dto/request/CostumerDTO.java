package com.br.thomasvcgApi.domain.dto.request;

import com.br.thomasvcgApi.domain.entity.CostumerAddress;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.util.Relationship;

import java.util.Date;

public record CostumerDTO(
       String costumer_name,
       Relationship relationship,

       String email,

       String contact,

       Date birtday,

       String rg,
       String cpf,
       CostumerAddress address,
       User user_id
) {
}
