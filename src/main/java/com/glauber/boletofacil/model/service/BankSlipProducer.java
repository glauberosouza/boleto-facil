package com.glauber.boletofacil.model.service;

import com.glauber.boletofacil.avro.bank_slip_record.BankSlipRecord;
import com.glauber.boletofacil.model.entity.BankSlip;

public interface BankSlipProducer {
    void send(BankSlipRecord bankSlipRecord);
}
