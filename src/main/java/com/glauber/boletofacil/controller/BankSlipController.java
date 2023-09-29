package com.glauber.boletofacil.controller;

import com.glauber.boletofacil.controller.request.BankSlipRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bank-slips")
public class BankSlipController {
    @PostMapping
    public ResponseEntity<Void> generate(@RequestBody BankSlipRequest bankSlipRequest){

    }
}
