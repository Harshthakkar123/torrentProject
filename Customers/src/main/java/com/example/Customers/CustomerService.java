package com.example.Customers;

import com.example.Customers.RabbitMqSender.RabbitMqConstants;
import com.example.Customers.RabbitMqSender.RabbitMqSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RabbitMqSend rabbitMqSender;

    @Autowired
    CustomerConverter customerConverter;
    public void addFtpServer(PaymentDto customerDto) {
        try {
            //FtpServer ftpServer1 = ftpServerConverter.convertDtoToEntity(ftpServer);
            // List<CustomerModel> ftpServerList = customerRepository.findAll();
               CustomerModel protocol = customerConverter.convertDtoToEntity(customerDto);

            customerRepository.save(protocol);
            rabbitMqSender.send(protocol, RabbitMqConstants.Customer_QUEUE_SEND_TO_Payment);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
//    }
//    public CustomerModel updateCorrelationField(PaymentDto correlationFieldDto, Long id){
//       // log.info("Started execution of updateCorrelationField method");
//        CustomerModel sacve = null;
//try {
//    //log.debug("Checking if Correlation Field: {} with id: [{}] is exist in database", correlationFieldDto, id);
//    CustomerModel correlationFieldExist = customerRepository.findById(id).get();
//
//
//    // log.info("Correlation Field of Id: {} is exist, Updating server...", id);
//
//    correlationFieldExist.setName(correlationFieldDto.getName());
//    correlationFieldExist.setStatus(correlationFieldDto.getStatus());
//    correlationFieldExist.setCustomerNo(correlationFieldDto.getCustomerNo());
//    correlationFieldExist.setCustomerEmail(correlationFieldDto.getCustomerEmail());
//
//
//    sacve = customerRepository.save(correlationFieldExist);
//}catch (NoSuchElementException n){
//
//}catch (NullPointerException ne){
//
//}
//        return sacve;
//       // return correlationFieldExist.get();
//    }
//    public  void test(){}
//

}
