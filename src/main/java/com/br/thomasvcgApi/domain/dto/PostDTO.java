package com.br.thomasvcgApi.domain.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
@Builder
public record PostDTO(
        Long id,
        String title,
        String subtitle,
        LocalDate date,
        List<String> tags,
        String content,
        UserDTO user
) {
}
