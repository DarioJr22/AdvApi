package com.br.thomasvcgApi.rest.request;

import java.util.Date;
import java.util.List;

public record PostRequest(
        String title,
        String subtitulo,
        Date date,
        List<String> tags,
        String content,
        Long idUser
) {
}
