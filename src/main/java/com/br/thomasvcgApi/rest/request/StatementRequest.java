package com.br.thomasvcgApi.rest.request;

import com.br.thomasvcgApi.domain.dto.CostumerDTO;

public record StatementRequest(
        String statementContent,
        String arqContent,
        String statementDescription,
        String statementAmount,
        CostumerDTO costumer
){
}
