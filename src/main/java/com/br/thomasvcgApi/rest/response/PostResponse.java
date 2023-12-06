package com.br.thomasvcgApi.rest.response;

import com.br.thomasvcgApi.domain.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private PostDTO postDTO;

    private String msg;

    public PostResponse(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public PostResponse(String msg) {
        this.msg = msg;
    }
}
