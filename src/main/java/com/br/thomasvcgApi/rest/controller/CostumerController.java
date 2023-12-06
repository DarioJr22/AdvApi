package com.br.thomasvcgApi.rest.controller;

import com.br.thomasvcgApi.rest.request.CostumerRequest;
import com.br.thomasvcgApi.rest.response.CostumerResponse;
import com.br.thomasvcgApi.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("costumer")
public class CostumerController {
    @Autowired
    private CostumerService costumerService;

    @PostMapping(value = "/user/{idUser}")
    public ResponseEntity<CostumerResponse> createCostumer(@RequestBody CostumerRequest contactDTO,@PathVariable Long idUser){
        CostumerResponse response = costumerService.createCostumer(contactDTO,idUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
