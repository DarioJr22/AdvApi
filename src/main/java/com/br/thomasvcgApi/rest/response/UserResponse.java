package com.br.thomasvcgApi.rest.response;

import com.br.thomasvcgApi.domain.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private UserDTO userDTO;

    private String msg;

    public UserResponse(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    public UserResponse(String msg) {
        this.msg = msg;
    }
}
