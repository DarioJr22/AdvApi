package com.br.thomasvcgApi.rest.request;

import com.br.thomasvcgApi.domain.dto.CostumerDTO;

public record ContactRequest(
        String contactContent,
        String arq_content,
        CostumerDTO costumer

) {
}
