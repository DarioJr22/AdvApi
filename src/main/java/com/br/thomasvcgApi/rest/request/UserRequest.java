package com.br.thomasvcgApi.rest.request;

import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import com.br.thomasvcgApi.domain.dto.PostDTO;
import com.br.thomasvcgApi.util.Role;

import java.util.List;

public record UserRequest(
        String login,
        String password,
        Role role,
        String email,
        List<PostDTO> posts,
        List<CostumerDTO> costumers

) {
}
