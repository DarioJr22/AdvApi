package com.br.thomasvcgApi.domain.entity;


import com.br.thomasvcgApi.domain.dto.CostumerDTO;
import com.br.thomasvcgApi.rest.request.CostumerRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="costumerAddress")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CostumerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_costumerAddress")
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "district")
    private String district;
    @Column(name = "cep")
    private String cep;
    @Column(name = "number")
    private int number;
    @Column(name = "complement")
    private String complement;
    @Column(name = "city")
    private String city;
    @Column(name = "uf")
    private String uf;

    public CostumerAddress(CostumerRequest request) {
        this.street = request.address().street();
        this.district = request.address().district();
        this.cep = request.address().cep();
        this.number = request.address().number();
        this.complement = request.address().complement();
        this.city = request.address().city();
        this.uf = request.address().uf();
    }

}
