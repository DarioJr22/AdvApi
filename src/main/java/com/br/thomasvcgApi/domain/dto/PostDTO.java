package com.br.thomasvcgApi.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PostDTO(
        Long id,
        String title,
        String subtitle,
        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
        LocalDate date,
        List<String> tags,
        String content,
        UserDTO user
) {
}
