package com.br.thomasvcgApi.domain.dto;

import lombok.Builder;

@Builder
public record StatementDTO (
        Long id,
        String statementContent,
        String arqContent,
        CostumerDTO costumer
){
}
