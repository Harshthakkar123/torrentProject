package com.example.Payment.Kafka;

import com.example.Payment.PaymentDto;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentDtoDeserializer implements Deserializer<PaymentDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PaymentDto deserialize(String topic, byte[] data) {
        // Implement the deserialization logic here
        // Convert the byte array to a PaymentDto object using the ObjectMapper
        try {
            return objectMapper.readValue(data, PaymentDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
