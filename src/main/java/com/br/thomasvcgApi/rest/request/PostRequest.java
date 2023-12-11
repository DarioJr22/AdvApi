package com.br.thomasvcgApi.rest.request;

import com.br.thomasvcgApi.domain.entity.User;

import java.time.LocalDate;
import java.util.List;

public record PostRequest(
        String title,
        String subtitle,
        LocalDate date,
        List<String> tags,
        String content,
        User user
) {
}
