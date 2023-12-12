package com.br.thomasvcgApi.rest.response;

import com.br.thomasvcgApi.domain.dto.ContactDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactResponse {
    private ContactDTO contactDTO;

    private String msg;

    public ContactResponse(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }

    public ContactResponse(String msg) {
        this.msg = msg;
    }
}
