package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.dto.ContactDTO;
import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import com.br.thomasvcgApi.domain.entity.Contact;
import com.br.thomasvcgApi.domain.entity.Costumer;
import com.br.thomasvcgApi.domain.repository.ContactRepository;
import com.br.thomasvcgApi.domain.repository.CostumerRepository;
import com.br.thomasvcgApi.exception.handler.HandlerEntityNotFoundException;
import com.br.thomasvcgApi.exception.handler.HandlerError;
import com.br.thomasvcgApi.rest.request.ContactRequest;
import com.br.thomasvcgApi.rest.response.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CostumerRepository costumerRepository;

    public ContactResponse createContact(ContactRequest contactRequest, Long idCostumer){
        Costumer costumer = costumerRepository.findById(idCostumer)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found with id" + idCostumer));
        try {
            Contact contact = new Contact();
            contact.setContactContent(contactRequest.contact_content());
            contact.setArqContent(contactRequest.arq_content());
            contact.setCostumer(costumer);
            contactRepository.save(contact);

            return new ContactResponse("Contact created successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public List<ContactResponse> getAll(){
        try {
            List<Contact> contacts = contactRepository.findAll();
            List<ContactResponse> responses = new ArrayList<>();

            contacts.parallelStream()
                    .forEach(contact -> {
                        var costumer = contact.getCostumer();
                        CostumerDTO costumerDTO = CostumerDTO.builder()
                                .id(costumer.getId())
                                .costumerName(costumer.getCostumerName())
                                .email(costumer.getEmail())
                                .build();
                        ContactResponse response = new ContactResponse(ContactDTO.builder()
                                .id(contact.getId())
                                .contactContent(contact.getContactContent())
                                .arqContent(contact.getContactContent())
                                .costumer(costumerDTO)
                                .build());
                        responses.add(response);
            });
            return responses;
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }

    public ContactResponse findById(Long idContact){
        Contact contact = contactRepository.findById(idContact)
                .orElseThrow(()-> new HandlerEntityNotFoundException("Contact not found with id" + idContact));
        var costumer = contact.getCostumer();
        CostumerDTO costumerDTO = CostumerDTO.builder()
                .id(costumer.getId())
                .costumerName(costumer.getCostumerName())
                .email(costumer.getEmail())
                .build();
        return new ContactResponse(ContactDTO.builder()
                .id(contact.getId())
                .contactContent(contact.getContactContent())
                .arqContent(contact.getContactContent())
                .costumer(costumerDTO)
                .build());
    }
    public ContactResponse update(ContactRequest contactRequest,Long idContact){
        Contact contact = contactRepository.findById(idContact)
                .orElseThrow(()-> new HandlerEntityNotFoundException("Contact not found with id" + idContact));
        Costumer costumer = costumerRepository.findById(contactRequest.costumer().id())
                .orElseThrow(()-> new HandlerEntityNotFoundException("Costumer not found with id" + contactRequest.costumer()));
        try {
            contact.setContactContent(contactRequest.contact_content());
            contact.setArqContent(contactRequest.arq_content());
            contact.setCostumer(costumer);
            contactRepository.save(contact);

            return new ContactResponse("Contact update successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ContactResponse deleteContact(Long idContact){
        try {
            contactRepository.deleteById(idContact);
            return new ContactResponse("Contact delete successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }

    }


}
