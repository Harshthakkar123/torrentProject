package com.example.Payment.Kafka;

import com.example.Payment.PaymentDto;
import com.example.Payment.PaymentModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Subscriber {

    @KafkaListener(topics = "archived_docs", groupId = "archived")
    public void consume(String message) throws IOException {
        System.out.println(String.format("$$ -> Consumed Message -> %s",message));
        ObjectMapper mapper = new ObjectMapper();
        JsonParser parser = mapper.createParser(message);
        PaymentDto product =  parser.readValueAs(PaymentDto.class);

        System.out.println(product.getName());
    }
}
