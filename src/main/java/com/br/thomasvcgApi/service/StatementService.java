package com.br.thomasvcgApi.service;

import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import com.br.thomasvcgApi.domain.dto.StatementDTO;
import com.br.thomasvcgApi.domain.entity.Costumer;
import com.br.thomasvcgApi.domain.entity.Statement;
import com.br.thomasvcgApi.domain.repository.CostumerRepository;
import com.br.thomasvcgApi.domain.repository.StatementRepository;
import com.br.thomasvcgApi.exception.handler.HandlerEntityNotFoundException;
import com.br.thomasvcgApi.exception.handler.HandlerError;
import com.br.thomasvcgApi.rest.request.StatementRequest;
import com.br.thomasvcgApi.rest.response.StatementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StatementService {

    @Autowired
    private StatementRepository statementRepository;

    @Autowired
    private CostumerRepository costumerRepository;

    public StatementResponse createStatement(StatementRequest statementRequest, Long idCostumer){

        Costumer costumer = costumerRepository.findById(idCostumer)
                .orElseThrow(()->new HandlerEntityNotFoundException("Costumer not found with id" + idCostumer));
        Statement statement = new Statement();
        statement.setStatementContent(statementRequest.statementContent());
        statement.setStatementDescription(statementRequest.statementDescription());
        statement.setStatementAmount(statementRequest.statementAmount());
        statement.setArqContent(statementRequest.arqContent());
        statement.setDate(LocalDate.now());
        statement.setCostumer(costumer);
        statementRepository.save(statement);

        return new StatementResponse("Statement created successfully!");
    }
    public List<StatementResponse> getAllStatements(){

        List<Statement> statements = statementRepository.findAll();
        List<StatementResponse> responses = new ArrayList<>();
        try {
            statements.forEach(statement -> {
                var costumer = statement.getCostumer();

                CostumerDTO costumerDTO = CostumerDTO.builder()
                        .id(costumer.getId())
                        .email(costumer.getEmail())
                        .cpf(costumer.getCpf())
                        .costumerName(costumer.getCostumerName())
                        .build();
                StatementDTO statementDTO = StatementDTO.builder()
                        .id(statement.getId())
                        .statementContent(statement.getStatementContent())
                        .statementDescription(statement.getStatementDescription())
                        .statementAmount(statement.getStatementAmount())
                        .arqContent(statement.getArqContent())
                        .statementDate(statement.getStatementDate())
                        .costumer(costumerDTO)
                        .build();
                StatementResponse response = new StatementResponse();
                response.setStatementDTO(statementDTO);
                responses.add(response);
            });
            return responses;
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public StatementResponse findStatementById(Long idStatement){

        Statement statement = statementRepository.findById(idStatement)
                .orElseThrow(()->new HandlerEntityNotFoundException("Statement not found with id" + idStatement));

        var costumer = statement.getCostumer();
        try {
            CostumerDTO costumerDTO = CostumerDTO.builder()
                    .id(costumer.getId())
                    .costumerName(costumer.getCostumerName())
                    .cpf(costumer.getCpf())
                    .email(costumer.getEmail())
                    .build();

            return new StatementResponse(StatementDTO.builder()
                    .arqContent(statement.getArqContent())
                    .statementContent(statement.getStatementContent())
                    .id(statement.getId())
                    .statementDescription(statement.getStatementDescription())
                    .statementAmount(statement.getStatementAmount())
                    .statementDate(statement.getStatementDate())
                    .costumer(costumerDTO)
                    .build());
        } catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public StatementResponse updateStatement(StatementRequest statementRequest, Long idStatement){

        Statement statement = statementRepository.findById(idStatement)
                .orElseThrow(()->new HandlerEntityNotFoundException("Statement not found with id" + idStatement));
        statement.setArqContent(statementRequest.arqContent());
        statement.setStatementContent(statementRequest.statementContent());
        statement.setStatementDescription(statementRequest.statementDescription());
        statement.setStatementAmount(statementRequest.statementAmount());
        statementRepository.save(statement);

        return new StatementResponse("Updated Successfully");
    }
    public StatementResponse deleteStatement(Long idStatement){

        Statement statement = statementRepository.findById(idStatement)
                .orElseThrow(() -> new HandlerEntityNotFoundException("Statement not found with id" + idStatement));
        statementRepository.delete(statement);

        return new StatementResponse("Deleted Successfully");
    }
}
