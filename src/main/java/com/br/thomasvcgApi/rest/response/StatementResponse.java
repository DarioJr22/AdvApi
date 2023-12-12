package com.br.thomasvcgApi.rest.response;

import com.br.thomasvcgApi.domain.dto.StatementDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatementResponse {
    private StatementDTO statementDTO;

    private String msg;

    public StatementResponse(StatementDTO statementDTO) {
        this.statementDTO = statementDTO;
    }

    public StatementResponse(String msg) {
        this.msg = msg;
    }
}
