package com.example.Payment.RabbitMqReceiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMqReceiverConfigs {
//    @Bean
//    Queue customerQueue() {
//        return QueueBuilder.durable(RabbitMqConstants.Customer_QUEUE).build();
//    }

//    @Bean
//    DirectExchange customerExchange() {
//        return new DirectExchange(RabbitMqConstants.Customer_EXCHANGE);
//    }
//
//    @Bean
//    Binding bind() {
//        return BindingBuilder.bind(customerQueue()).to(customerExchange()).with(RabbitMqConstants.Customer_KEY);
//    }

    @Bean
    public DirectExchange Exchange() {
        return new DirectExchange(RabbitMqConstants.ADOPT_EXCHANGE);
    }

    @Bean
    @Primary
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new CustomMessageConverter(objectMapper);
    }

    @Bean
    public AmqpTemplate rabbit(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
    @Bean
    public Queue PaymentReceive(){
        return QueueBuilder.durable(RabbitMqConstants.Customer_QUEUE_RECEIVER_TO_Payment)
                .withArgument("x-customer-exchange", RabbitMqConstants.Customer_EXCHANGE)
                .withArgument("x-customer-routing-key", RabbitMqConstants.Customer_KEY)
                .build();
    }
    @Bean
    public Binding Paymentinding() {
        return BindingBuilder.bind(PaymentReceive()).to(Exchange()).withQueueName();
    }
}


