package com.example.Payment.RabbitMqconfig;

import com.example.Payment.PaymentDto;
import com.example.Payment.PaymentModel;
import org.apache.logging.log4j.LogManager;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.amqp.core.Queue;

import java.util.logging.Logger;

@Component
public class RabbitMqSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send(PaymentDto menuOrder, String quename) {

        rabbitTemplate.convertAndSend(RabbitMqConstants.ADOPT_EXCHANGE,quename, menuOrder);
       System.out.println("Sending Message to the Queue : " + menuOrder.toString());
    }
}
