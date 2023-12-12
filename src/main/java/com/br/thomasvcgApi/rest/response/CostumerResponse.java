package com.br.thomasvcgApi.rest.response;

import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CostumerResponse {
    private CostumerDTO costumerDTO;

    private String msg;

    public CostumerResponse(CostumerDTO costumerDTO) {
        this.costumerDTO = costumerDTO;
    }

    public CostumerResponse(String msg) {
        this.msg = msg;
    }
}
