package com.br.thomasvcgApi.domain.dto;

import lombok.Builder;

@Builder
public record UserDTO(
        Long id,
        String login,
        String password,
        String email
) {
}
