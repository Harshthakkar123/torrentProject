package com.example.Customers.RabbitMqSender;
import com.example.Customers.CustomerModel;
import com.example.Customers.PaymentDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomMessageConverter implements MessageConverter {
    private final ObjectMapper objectMapper;

    public CustomMessageConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        try {
            byte[] bytes = objectMapper.writeValueAsBytes(object);
            messageProperties.setContentType("application/json");
            messageProperties.setContentEncoding("UTF-8");
            messageProperties.setContentLength(bytes.length);
            return new Message(bytes, messageProperties);
        } catch (Exception e) {
            throw new MessageConversionException("Failed to convert object to Message", e);
        }
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        try {
            byte[] bytes = message.getBody();
            return objectMapper.readValue(bytes, PaymentDto.class);
        } catch (Exception e) {
            throw new MessageConversionException("Failed to convert Message to object", e);
        }
    }
}
