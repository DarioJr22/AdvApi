package com.br.thomasvcgApi.service;


import com.br.thomasvcgApi.domain.dto.CostumerAddressDTO;
import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import com.br.thomasvcgApi.domain.dto.UserDTO;
import com.br.thomasvcgApi.domain.entity.Costumer;
import com.br.thomasvcgApi.domain.entity.CostumerAddress;
import com.br.thomasvcgApi.domain.entity.User;
import com.br.thomasvcgApi.domain.repository.CostumerAddressRepository;
import com.br.thomasvcgApi.domain.repository.CostumerRepository;
import com.br.thomasvcgApi.domain.repository.UserRepository;
import com.br.thomasvcgApi.exception.handler.HandlerEntityNotFoundException;
import com.br.thomasvcgApi.exception.handler.HandlerError;
import com.br.thomasvcgApi.rest.request.CostumerRequest;
import com.br.thomasvcgApi.rest.response.CostumerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CostumerAddressRepository costumerAddressRepository;

    public CostumerResponse createCostumer(CostumerRequest costumerRequest, Long idUser){
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found with id" + idUser));
        try {
            var addressRequest = costumerRequest.address();
            CostumerAddress address = new CostumerAddress();
            address.setCep(addressRequest.cep());
            address.setUf(addressRequest.uf());
            address.setCity(addressRequest.city());
            address.setDistrict(addressRequest.district());
            address.setNumber(addressRequest.number());
            address.setComplement(addressRequest.complement());
            address.setStreet(addressRequest.street());
            costumerAddressRepository.save(address);

            Costumer costumer = new Costumer();
            costumer.setCostumerName(costumerRequest.costumerName());
            costumer.setRg(costumerRequest.rg());
            costumer.setCpf(costumerRequest.cpf());
            costumer.setContact(costumerRequest.contact());
            costumer.setBirthday(costumerRequest.birthday());
            costumer.setAddress(address);
            costumer.setEmail(costumerRequest.email());
            costumer.setRelationship(costumerRequest.relationship());
            costumer.setUser(user);
            costumerRepository.save(costumer);
            
            return new CostumerResponse("Costumer created successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public List<CostumerResponse> getAllCostumer(){
        List<Costumer> costumers = costumerRepository.findAll();
        List<CostumerResponse> responses = new ArrayList<>();
        try {
            costumers.parallelStream().forEach(costumer -> {
                var address = costumer.getAddress();
                var user = costumer.getUser();
                CostumerAddressDTO addressDTO = CostumerAddressDTO.builder()
                        .id(address.getId())
                        .cep(address.getCep())
                        .city(address.getCity())
                        .complement(address.getComplement())
                        .district(address.getDistrict())
                        .number(address.getNumber())
                        .street(address.getStreet())
                        .uf(address.getUf())
                        .build();
                UserDTO userDTO = UserDTO.builder()
                        .login(user.getLogin())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build();
                CostumerResponse response = new CostumerResponse(CostumerDTO.builder()
                        .id(costumer.getId())
                        .email(costumer.getEmail())
                        .costumerName(costumer.getCostumerName())
                        .address(addressDTO)
                        .rg(costumer.getRg())
                        .birthday(costumer.getBirthday())
                        .contact(costumer.getContact())
                        .cpf(costumer.getCpf())
                        .relationship(costumer.getRelationship())
                        .user(userDTO)
                        .build());
                responses.add(response);
            });
            return responses;
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }

    public CostumerResponse findByIdCostumer(Long idCostumer){
        Costumer costumer = costumerRepository.findById(idCostumer)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found with id" + idCostumer));
        try {
            var address = costumer.getAddress();
            var user = costumer.getUser();
            CostumerAddressDTO addressDTO = CostumerAddressDTO.builder()
                    .id(address.getId())
                    .cep(address.getCep())
                    .city(address.getCity())
                    .complement(address.getComplement())
                    .district(address.getDistrict())
                    .number(address.getNumber())
                    .street(address.getStreet())
                    .uf(address.getUf())
                    .build();
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .login(user.getLogin())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build();
            return new CostumerResponse(CostumerDTO.builder()
                                .id(costumer.getId())
                                .email(costumer.getEmail())
                                .costumerName(costumer.getCostumerName())
                                .address(addressDTO)
                                .rg(costumer.getRg())
                                .birthday(costumer.getBirthday())
                                .contact(costumer.getContact())
                                .cpf(costumer.getCpf())
                                .relationship(costumer.getRelationship())
                                .user(userDTO)
                                .build());
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }

    public CostumerResponse updateCostumer(CostumerRequest costumerRequest, Long idCostumer){
        Costumer costumer = costumerRepository.findById(idCostumer)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found with id" + idCostumer));

        User user = userRepository.findById(costumerRequest.user().getId())
                .orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found with id" + costumerRequest.user().getId()));
        try {
            var addressRequest = costumerRequest.address();
            CostumerAddress address = new CostumerAddress();
            address.setCep(addressRequest.cep());
            address.setUf(addressRequest.uf());
            address.setCity(addressRequest.city());
            address.setDistrict(addressRequest.district());
            address.setNumber(addressRequest.number());
            address.setComplement(addressRequest.complement());
            address.setStreet(addressRequest.street());
            costumerAddressRepository.save(address);

            costumer.setCostumerName(costumerRequest.costumerName());
            costumer.setRg(costumerRequest.rg());
            costumer.setCpf(costumerRequest.cpf());
            costumer.setContact(costumerRequest.contact());
            costumer.setBirthday(costumerRequest.birthday());
            costumer.setAddress(address);
            costumer.setEmail(costumerRequest.email());
            costumer.setRelationship(costumerRequest.relationship());
            costumer.setUser(user);
            costumerRepository.save(costumer);

            return new CostumerResponse("Costumer update successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }

    public CostumerResponse deleteCostumer(Long idCostumer){
        Costumer costumer = costumerRepository.findById(idCostumer)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found with id" + idCostumer));
        try {
            costumerRepository.delete(costumer);
            return new CostumerResponse("Costumer delete successfully");
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }



}
