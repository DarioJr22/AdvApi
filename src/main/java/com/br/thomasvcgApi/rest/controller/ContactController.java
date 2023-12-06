package com.br.thomasvcgApi.rest.controller;

import com.br.thomasvcgApi.rest.request.ContactRequest;
import com.br.thomasvcgApi.rest.response.ContactResponse;
import com.br.thomasvcgApi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(value = "/costumer/{idCostumer}")
    public ResponseEntity<ContactResponse> createContact(@RequestBody ContactRequest contactRequest, @PathVariable Long idCostumer){
        ContactResponse response = contactService.createContact(contactRequest,idCostumer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(){
        List<ContactResponse> responses = contactService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }
    @GetMapping(value = "/{idContact}")
    public ResponseEntity<ContactResponse> findBy(@PathVariable Long idContact){
        ContactResponse response = contactService.findById(idContact);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping(value = "/{idContact}")
    public ResponseEntity<ContactResponse> update(@RequestBody ContactRequest contactRequest,@PathVariable Long idContact){
        ContactResponse response = contactService.update(contactRequest,idContact);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping(value = "/{idContact}")
    public ResponseEntity<ContactResponse> deleteContact(@PathVariable Long idContact){
        ContactResponse response = contactService.deleteContact(idContact);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
