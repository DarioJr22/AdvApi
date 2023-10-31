package com.br.thomasvcgApi.domain.entity;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class CostumerAddress {


    private String street;

    private String district;

    private String cep;

    private Integer numero;

    private String complement;

    private String cidade;

    private String uf;


    public CostumerAddress(
            String street,
            String district,
            String cep,
            Integer numero,
            String complement,
            String cidade,
            String uf) {
        this.street = street;
        this.district = district;
        this.cep = cep;
        this.numero = numero;
        this.complement = complement;
        this.cidade = cidade;
        this.uf = uf;
    }
}
