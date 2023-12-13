package com.br.thomasvcgApi.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record StatementDTO (
        Long id,
        String statementContent,
        String arqContent,
        String statementDescription,
        Double statementAmount,
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
        LocalDate statementDate
        CostumerDTO costumer
){
}
