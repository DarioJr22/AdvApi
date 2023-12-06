package com.br.thomasvcgApi.domain.dto;

import lombok.Builder;

@Builder
public record ContactDTO(
        Long id,
        String contactContent,
        String arqContent,
        CostumerDTO costumer) {
}
