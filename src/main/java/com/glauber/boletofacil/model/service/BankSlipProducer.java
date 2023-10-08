package com.glauber.boletofacil.model.service;

import com.glauber.boletofacil.avro.bank_slip_record.BankSlipRecord;

public interface BankSlipProducer {
    void send(BankSlipRecord bankSlipRecord);
}
