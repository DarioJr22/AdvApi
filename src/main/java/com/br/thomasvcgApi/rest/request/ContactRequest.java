package com.br.thomasvcgApi.rest.request;

public record ContactRequest(
        String contact_content,
        String arq_content,
        Long idCostumer

) {
}
