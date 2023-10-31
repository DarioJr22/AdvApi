package com.br.thomasvcgApi.domain.dto.request;

public record ContactDTO(
        String contact_content,
        String arq_content,
        Long client_id

) {
}
