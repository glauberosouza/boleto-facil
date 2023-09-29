package com.glauber.boletofacil.controller.request;

import com.glauber.boletofacil.domain.entity.BankSlip;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BankSlipRequest {
    private String name;
    private String email;
    private String cpf;
    BigDecimal value;

    public static BankSlipRequest from(BankSlip bankSlip) {
        return BankSlipRequest.builder()
                .name(bankSlip.getName())
                .email(bankSlip.getEmail())
                .cpf(bankSlip.getCpf())
                .value(bankSlip.getValue())
                .build();
    }
}