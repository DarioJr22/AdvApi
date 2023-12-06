package com.br.thomasvcgApi.rest.request;

import com.br.thomasvcgApi.domain.dto.CostumerDTO;

public record ContactRequest(
        String contact_content,
        String arq_content,
        CostumerDTO costumer

) {
}
