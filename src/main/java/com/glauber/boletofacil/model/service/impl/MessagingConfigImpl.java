package com.glauber.boletofacil.model.service.impl;

import com.glauber.boletofacil.configuration.KafkaProperties;
import com.glauber.boletofacil.model.service.MessagingConfigPort;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.MAX_POLL_RECORDS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class MessagingConfigImpl<T extends SpecificRecordBase> implements MessagingConfigPort<T> {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean(name = "messageSender")
    @Override
    public KafkaProducer<String, T> configureProducer() {
        var properties = new Properties();

        properties.put(BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ACKS_CONFIG, kafkaProperties.getAcksConfig());
        properties.put(RETRIES_CONFIG, kafkaProperties.getRetriesConfig());
        properties.put(KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getKeySerializer());
        properties.put(VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getValueSerializer());
        properties.put(SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getSchemaRegistryUrl());
        properties.put(MAX_POLL_RECORDS_CONFIG, kafkaProperties.getMaxPollRecordsConfig());

        return new KafkaProducer<>(properties);
    }
}