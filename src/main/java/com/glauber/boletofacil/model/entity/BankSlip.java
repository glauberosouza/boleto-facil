package com.glauber.boletofacil.model.entity;

import com.glauber.boletofacil.avro.bank_slip_record.BankSlipRecord;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Entity
public class BankSlip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String email;
    String cpf;
    BigDecimal value;
    BankSlipStatus status;
    @Column(name = "created_at")
    LocalDate createdAt;
    @Column(name = "sent_at")
    LocalDate sentAt;

    public BankSlipRecord toRecord() {
        return BankSlipRecord.newBuilder()
                .setId(this.id)
                .setName(this.name)
                .setEmail(this.email)
                .setCpf(this.cpf)
                .setValue(this.value.doubleValue())
                .build();

    }
}
