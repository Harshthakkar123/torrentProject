package com.example.Customers.Kafka;


import com.example.Customers.CustomerModel;
import com.example.Customers.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/archive")
public class PublisherController {
    @Autowired
    Publisher producer;

    @Autowired
    private KafkaTemplate<String, PaymentDto> kafkaTemplate;

    @Autowired
    public PublisherController(Publisher producer) {
        this.producer = producer;
    }
    private static final String TOPIC = "archived_docs";

    @CrossOrigin(origins = "*")
    @PostMapping(value="",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessageToKafkaTopic(@RequestBody PaymentDto customerModel){
        kafkaTemplate.send(TOPIC,customerModel);
    }
}