package com.br.thomasvcgApi.rest.controller;

import com.br.thomasvcgApi.rest.request.StatementRequest;
import com.br.thomasvcgApi.rest.response.StatementResponse;
import com.br.thomasvcgApi.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("statement")
public class StatementController {

    @Autowired
    private StatementService statementService;

    @PostMapping(value = "/costumer/{idCostumer}")
    public ResponseEntity<StatementResponse> createStatement(@RequestBody StatementRequest statementRequest, @PathVariable Long idCostumer) {
        StatementResponse statementResponses = statementService.createStatement(statementRequest, idCostumer);
        return ResponseEntity.status(HttpStatus.CREATED).body(statementResponses);
    }

    @GetMapping
    public ResponseEntity<List<StatementResponse>> getAllStatements() {
        List<StatementResponse> statementResponses = statementService.getAllStatements();
        return ResponseEntity.status(HttpStatus.OK).body(statementResponses);
    }

    @GetMapping(value = "/{idStatement}")
    public ResponseEntity<StatementResponse> findStatementById(@PathVariable Long idStatement) {
        StatementResponse statementResponse = statementService.findStatementById(idStatement);
        return ResponseEntity.status(HttpStatus.OK).body(statementResponse);
    }

    @PutMapping(value = "/{idStatement}")
    public ResponseEntity<StatementResponse> updateStatement(@RequestBody StatementRequest statementRequest, @PathVariable Long idStatement) {
        StatementResponse statementResponse = statementService.updateStatement(statementRequest, idStatement);
        return ResponseEntity.status(HttpStatus.OK).body(statementResponse);
    }

    @DeleteMapping(value = "/{idStatement}")
    public ResponseEntity<StatementResponse> deleteStatement(@PathVariable Long idStatement) {
        StatementResponse statementResponse = statementService.deleteStatement(idStatement);
        return ResponseEntity.status(HttpStatus.OK).body(statementResponse);
    }
}
