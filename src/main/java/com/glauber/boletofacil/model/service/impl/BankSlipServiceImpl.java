package com.glauber.boletofacil.model.service.impl;

import com.glauber.boletofacil.model.entity.BankSlip;
import com.glauber.boletofacil.model.entity.BankSlipStatus;
import com.glauber.boletofacil.model.repository.BankSlipRepository;
import com.glauber.boletofacil.model.service.BankSlipProducer;
import com.glauber.boletofacil.model.service.BankSlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankSlipServiceImpl implements BankSlipService {
    private final BankSlipRepository repository;
    private final BankSlipProducer producer;

    @Autowired

    public BankSlipServiceImpl(BankSlipRepository repository, BankSlipProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Override
    public void save(BankSlip bankSlip) {
        bankSlip.setStatus(BankSlipStatus.REQUESTED);
        repository.save(bankSlip);
        producer.send(bankSlip.toRecord());
    }
}
