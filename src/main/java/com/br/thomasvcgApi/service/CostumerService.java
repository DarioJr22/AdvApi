package com.br.thomasvcgApi.service;


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

import java.util.List;
import java.util.Optional;

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
                .orElseThrow(() -> new HandlerEntityNotFoundException("Costumer not found whith id" + idUser));
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
            costumer.setBirtday(costumerRequest.birtday());
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

    public List<Costumer> getAll(){
        return costumerRepository.findAll();
    }

    public Optional<Costumer> findById(Long id){
        return costumerRepository.findById(id);
    }

    public void delete(Long cd){
        costumerRepository.deleteById(cd);
    }

    public Costumer update(Costumer c){
        return costumerRepository.save(c);
    }

}
