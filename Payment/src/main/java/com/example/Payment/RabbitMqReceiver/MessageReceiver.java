package com.example.Payment.RabbitMqReceiver;

import com.example.Payment.PaymentModel;
import com.example.Payment.PaymentRepository;
import com.example.Payment.PaymentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentService paymentService;
    @RabbitListener(queues = RabbitMqConstants.Customer_QUEUE_RECEIVER_TO_Payment)
    public void itemHistoryFromRms(PaymentModel message){
        // log.info("Received Message From RabbitMq : <" + message + ">");
        try {
            //inOutWardMACService.saveEntityFromIntegrationRms(message);
            System.out.println(message.getName());
            int id = message.getCustomerNo();
            paymentService.updateCorrelationField(message,id);
            // log.info("Inward Created Successfully From Rms");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

