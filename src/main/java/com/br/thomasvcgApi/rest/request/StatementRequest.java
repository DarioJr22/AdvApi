package com.br.thomasvcgApi.rest.request;

public record StatementRequest(
        String statementContent,
        String arqContent,
        Long idCostumer
){
}
