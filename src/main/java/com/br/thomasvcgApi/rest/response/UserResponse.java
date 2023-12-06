package com.br.thomasvcgApi.rest.response;

import com.br.thomasvcgApi.domain.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
