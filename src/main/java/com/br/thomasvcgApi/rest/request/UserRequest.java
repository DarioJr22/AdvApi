package com.br.thomasvcgApi.rest.request;

import com.br.thomasvcgApi.util.Role;

public record UserRequest(
        String login,
        String password,
        Role role,
        String email

) {
}
