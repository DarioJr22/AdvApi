package com.br.thomasvcgApi.rest.response;

import com.br.thomasvcgApi.domain.dto.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
