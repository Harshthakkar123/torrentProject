//package com.example.Customers.RabbitMq;
//
//
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMqConfigs {
//    @Bean
//    Queue deadLetterQueue() {
//        return QueueBuilder.durable(RabbitMqConstants.DEAD_LETTER_QUEUE).build();
//    }
//
//    @Bean
//    DirectExchange deadLetterExchange() {
//        return new DirectExchange(RabbitMqConstants.DEAD_LETTER_EXCHANGE);
//    }
//
//    @Bean
//    Binding DLQbinding() {
//        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(RabbitMqConstants.DEAD_LETTER_KEY);
//    }
//
//    @Bean
//    public DirectExchange adoptExchange() {
//        return new DirectExchange(RabbitMqConstants.ADOPT_EXCHANGE);
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//    @Bean
//    public Queue inwardSendToIntegration(){
//        return QueueBuilder.durable(RabbitMqConstants.PAYMENT_QUEUE_RECEIVER_TO_CUSTOMER)
//                .withArgument("x-dead-letter-exchange", RabbitMqConstants.DEAD_LETTER_EXCHANGE)
//                .withArgument("x-dead-letter-routing-key", RabbitMqConstants.DEAD_LETTER_KEY)
//                .build();
//    }
//    @Bean
//    public Binding inwardSendToIntegrationBinding() {
//        return BindingBuilder.bind(inwardSendToIntegration()).to(adoptExchange()).withQueueName();
//    }
//}
//
//
