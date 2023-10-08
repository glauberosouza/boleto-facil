package com.glauber.boletofacil.model.service;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.Producer;
/*
* Essa interface cria o método que configura o produtor kafka para enviar mensagens para algum tópico, onde a chave
* é do tipo String e o seu valor é do tipo T. O SpecificRecordBase permite trabalhar com objetos no schema avro.*/
public interface MessagingConfigPort<T extends SpecificRecordBase> {
    Producer<String, T> configureProducer();
}