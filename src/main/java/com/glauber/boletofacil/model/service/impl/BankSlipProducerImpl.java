package com.glauber.boletofacil.model.service.impl;

import com.glauber.boletofacil.avro.bank_slip_record.BankSlipRecord;
import com.glauber.boletofacil.model.service.BankSlipProducer;
import com.glauber.boletofacil.model.service.MessagingPort;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BankSlipProducerImpl implements MessagingPort<BankSlipRecord>, BankSlipProducer {
    @Autowired
    @Qualifier("messageSender")
    private KafkaProducer<String, BankSlipRecord> producer;

    @Override
    public String topic() {
        return "new-bank-slip";
    }

    @Override
    public ProducerRecord<String, BankSlipRecord> createProducerRecord(BankSlipRecord type) {
        return new ProducerRecord<>(topic(), UUID.randomUUID().toString(), type);
    }

    @Override
    public void send(BankSlipRecord type) {
        producer.send(createProducerRecord(type), (metadata, exception) -> {
            if (exception == null) {
                log.info("Data sent with success!!!");
            } else {
                log.error("Fail to send message");
            }
        });
    }
}
