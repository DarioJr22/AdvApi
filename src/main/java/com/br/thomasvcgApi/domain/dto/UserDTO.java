package com.br.thomasvcgApi.domain.dto;

import com.br.thomasvcgApi.util.Role;
import lombok.Builder;

@Builder
public record UserDTO(
        Long id,
        String login,
        String password,
        Role role,
        String email
) {
}
