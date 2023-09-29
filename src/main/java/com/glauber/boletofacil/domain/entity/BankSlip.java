package com.glauber.boletofacil.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Entity
public class BankSlip {
    long id;
    String name;
    String email;
    String cpf;
    BigDecimal value;
    BankSlipStatus status;
    LocalDate createdAt;
    LocalDate sentAt;
}
