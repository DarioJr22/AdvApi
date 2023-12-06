package com.br.thomasvcgApi.rest.request;

public record UserRequest(
        String login,
        String password,
        String email

) {
}
