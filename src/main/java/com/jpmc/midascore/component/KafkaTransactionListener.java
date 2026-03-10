package com.jpmc.midascore.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTransactionListener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${general.kafka-topic}")
    public void receive(String message) throws Exception {

        Transaction transaction =
                objectMapper.readValue(message, Transaction.class);

        System.out.println(transaction.getAmount());
    }
}
