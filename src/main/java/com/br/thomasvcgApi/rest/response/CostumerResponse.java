package com.br.thomasvcgApi.rest.response;

import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
