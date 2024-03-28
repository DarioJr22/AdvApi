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
        User user = userRepository.findById(idUser).orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found with id" + idUser));
        try {

            CostumerAddress address = new CostumerAddress(costumerRequest);
            costumerAddressRepository.save(address);

            Costumer costumer = new Costumer(costumerRequest);
            costumer.setAddress(address);
            costumer.setUser(user);
           Costumer costumerResp =  costumerRepository.save(costumer);


            
            return new CostumerResponse("Costumer created successfully", costumerResp);
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public List<CostumerResponse> getAllCostumer(){
        List<Costumer> costumers = costumerRepository.findAll();
        List<CostumerResponse> responses = new ArrayList<>();
        try {
            costumers.parallelStream().forEach(costumer -> {
                var user = costumer.getUser();
                CostumerAddressDTO addressDTO = new CostumerAddressDTO(costumer);

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

            var user = costumer.getUser();
            CostumerAddressDTO addressDTO = new CostumerAddressDTO(costumer);

            UserDTO userDTO = UserDTO.builder()

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

        try {
            var addressRequest = costumerRequest.address();

            costumer.getAddress().setCep(addressRequest.cep());
            costumer.getAddress().setUf(addressRequest.uf());
            costumer.getAddress().setCity(addressRequest.city());
            costumer.getAddress().setDistrict(addressRequest.district());
            costumer.getAddress().setNumber(addressRequest.number());
            costumer.getAddress().setComplement(addressRequest.complement());
            costumer.getAddress().setStreet(addressRequest.street());
            costumerAddressRepository.save(costumer.getAddress());

            costumer.setCostumerName(costumerRequest.costumerName());
            costumer.setRg(costumerRequest.rg());
            costumer.setCpf(costumerRequest.cpf());
            costumer.setContact(costumerRequest.contact());
            costumer.setBirthday(costumerRequest.birthday());
            costumer.setAddress(costumer.getAddress());
            costumer.setEmail(costumerRequest.email());
            costumer.setRelationship(costumerRequest.relationship());
<<<<<<< HEAD
            costumerRepository.save(costumer);
=======
            costumer.setUser(user);
            Costumer costumerResp =  costumerRepository.save(costumer);
>>>>>>> 58361cc617e4ee8f463b5899f8146e5b2d5954d6



            return new CostumerResponse("Costumer created successfully", costumerResp);
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }

    public CostumerResponse deleteCostumer(Long idCostumer){
        Costumer costumer = costumerRepository.findById(idCostumer)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found with id" + idCostumer));
        try {
            costumerRepository.delete(costumer);
            return new CostumerResponse("Costumer delete successfully",costumer);
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }



}
