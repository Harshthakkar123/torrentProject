package com.example.Customers.RabbitMq;

import com.example.Customers.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

//    @Autowired
//    CustomerConverter customerConverter;
    @RabbitListener(queues = RabbitMqConstants.PAYMENT_QUEUE_RECEIVER_TO_CUSTOMER)
    public void itemHistoryFromRms(PaymentDto message) {
        // log.info("Received Message From RabbitMq : <" + message + ">");
        try {
            //inOutWardMACService.saveEntityFromIntegrationRms(message);
           // CustomerModel paymentModel = customerConverter.convertDtoToEntity(message);
            System.out.println(message.getName());
            System.out.println(message.getFlag());
            Long id = message.getId();
            Boolean flags = message.getFlag();
            if(flags.booleanValue()==true) {
              //  customerService.updateCorrelationField(message, id);
            }
            // log.info("Inward Created Successfully From Rms");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
