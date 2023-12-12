package com.br.thomasvcgApi.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ContactDTO(
        Long id,
        String contactContent,
        String arqContent,
        CostumerDTO costumer) {
}
