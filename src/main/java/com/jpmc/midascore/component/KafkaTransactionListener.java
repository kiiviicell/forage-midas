package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTransactionListener {

    @KafkaListener(
        topics = "${general.kafka-topic}",
        properties = {
            "spring.json.value.default.type=com.jpmc.midascore.foundation.Transaction",
            "spring.json.trusted.packages=*"
        }
    )
    public void listen(Transaction transaction) {

        System.out.println(transaction.getAmount());

    }
}
