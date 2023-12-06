package com.br.thomasvcgApi.domain.dto;

import lombok.Builder;

import java.util.Date;
import java.util.List;
@Builder
public record PostDTO(
        Long id,
        String title,
        String subtitulo,
        Date date,
        List<String> tags,
        String content,
        UserDTO user
) {
}
