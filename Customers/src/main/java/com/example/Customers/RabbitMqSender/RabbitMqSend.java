package com.example.Customers.RabbitMqSender;

import com.example.Customers.CustomerModel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqSend {
    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send(CustomerModel menuOrder, String quename) {
        rabbitTemplate.convertAndSend(RabbitMqConstants.ADOPT_EXCHANGE,quename, menuOrder);
        System.out.println("Sending Message to the Queue : " + menuOrder.toString());
    }
}

