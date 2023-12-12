package com.br.thomasvcgApi.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StatementDTO (
        Long id,
        String statementContent,
        String arqContent,
        CostumerDTO costumer
){
}
