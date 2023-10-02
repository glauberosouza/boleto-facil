package com.glauber.boletofacil.controller;

import com.glauber.boletofacil.controller.request.BankSlipRequest;
import com.glauber.boletofacil.model.service.BankSlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bank-slips")
public class BankSlipController {
    private BankSlipService bankSlipService;

    @Autowired
    public BankSlipController(BankSlipService bankSlipService) {
        this.bankSlipService = bankSlipService;
    }

    @PostMapping
    public ResponseEntity<Void> generate(@RequestBody BankSlipRequest bankSlipRequest) {
        bankSlipService.save(bankSlipRequest.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}