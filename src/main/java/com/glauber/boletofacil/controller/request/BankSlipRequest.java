package com.glauber.boletofacil.controller.request;

import com.glauber.boletofacil.model.entity.BankSlip;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankSlipRequest {
    private String name;
    private String email;
    private String cpf;
    private BigDecimal value;

    public BankSlip toEntity() {
        return BankSlip.builder()
                .name(this.name)
                .email(this.email)
                .cpf(this.cpf)
                .value(this.value)
                .build();
    }
}