package com.br.thomasvcgApi.domain.dto.request;

public record UserDTO(
        String login,
        String password,
        String email

) {
}
