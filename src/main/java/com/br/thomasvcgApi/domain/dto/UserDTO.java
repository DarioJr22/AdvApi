package com.br.thomasvcgApi.domain.dto;

import com.br.thomasvcgApi.util.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDTO(
        Long id,
        String login,
        String password,
        Role role,
        String email,
        List<PostDTO>posts,
        List<CostumerDTO> costumers


) {
}
