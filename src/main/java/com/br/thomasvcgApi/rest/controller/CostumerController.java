package com.br.thomasvcgApi.rest.controller;

import com.br.thomasvcgApi.rest.request.CostumerRequest;
import com.br.thomasvcgApi.rest.response.CostumerResponse;
import com.br.thomasvcgApi.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("costumer")
public class CostumerController {
    @Autowired
    private CostumerService costumerService;

    @PostMapping(value = "/user/{idUser}")
    public ResponseEntity<CostumerResponse> createCostumer(@RequestBody CostumerRequest costumerRequest,@PathVariable Long idUser){
        CostumerResponse response = costumerService.createCostumer(costumerRequest,idUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<CostumerResponse>> getAllCostumer(){
        List<CostumerResponse> responses = costumerService.getAllCostumer();
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }
    @GetMapping(value = "/{idCostumer}")
    public ResponseEntity<CostumerResponse> findByIdCostumer(@PathVariable Long idCostumer){
        CostumerResponse response = costumerService.findByIdCostumer(idCostumer);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping(value = "/{idCostumer}")
    public ResponseEntity<CostumerResponse> updateCostumer(@RequestBody CostumerRequest costumerRequest,@PathVariable Long idCostumer){
        CostumerResponse response = costumerService.updateCostumer(costumerRequest,idCostumer);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping(value = "/{idCostumer}")
    public ResponseEntity<CostumerResponse> createCostumer(@PathVariable Long idCostumer){
        CostumerResponse response = costumerService.deleteCostumer(idCostumer);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
