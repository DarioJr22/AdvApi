package com.br.thomasvcgApi.rest.request;

import lombok.Data;

@Data
public class TagRequest {

    private String newTag;
    private String oldTag;

}
