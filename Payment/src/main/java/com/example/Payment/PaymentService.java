package com.example.Payment;

import com.example.Payment.RabbitMqconfig.RabbitMqConstants;
import com.example.Payment.RabbitMqconfig.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    RabbitMqSender rabbitMqSender;

    @Autowired
    PaymentConverter paymentConverter;
    @Autowired
    EmployeeRepository employeeRepository;

    public void addFtpServer(PaymentDto ftpServer) {
        Boolean flag = true;
        try {
            //FtpServer ftpServer1 = ftpServerConverter.convertDtoToEntity(ftpServer);
            // List<CustomerModel> ftpServerList = customerRepository.findAll();
            while (flag) {

                PaymentModel protocol = paymentConverter.convertDtoToEntity(ftpServer);
                paymentRepository.save(protocol);
                ftpServer.setFlag(flag);
                rabbitMqSender.send(ftpServer, RabbitMqConstants.PAYMENT_QUEUE_SEND_TO_CUSTOMER);
                flag = false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addEmployee(EmployeeModel ftpServer) {
        Boolean flag = true;
        try {
            //FtpServer ftpServer1 = ftpServerConverter.convertDtoToEntity(ftpServer);
            // List<CustomerModel> ftpServerList = customerRepository.findAll();


               // PaymentModel protocol = paymentConverter.convertDtoToEntity(ftpServer);
                employeeRepository.save(ftpServer);
                //ftpServer.setFlag(flag);
                //rabbitMqSender.send(ftpServer, RabbitMqConstants.PAYMENT_QUEUE_SEND_TO_CUSTOMER);
               // flag = false;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public PaymentModel updateCorrelationField(PaymentModel correlationFieldDto, int id){
        PaymentModel save = null;
        try {
            // log.info("Started execution of updateCorrelationField method");

            //log.debug("Checking if Correlation Field: {} with id: [{}] is exist in database", correlationFieldDto, id);
            PaymentModel correlationFieldExist = paymentRepository.findByCustomerNo(id);


            // log.info("Correlation Field of Id: {} is exist, Updating server...", id);

            correlationFieldExist.setName(correlationFieldDto.getName());
            correlationFieldExist.setStatus(correlationFieldDto.getStatus());
            correlationFieldExist.setCustomerEmail(correlationFieldDto.getCustomerEmail());
            correlationFieldExist.setCustomerNo(correlationFieldDto.getCustomerNo());

            save = paymentRepository.save(correlationFieldExist);
        }catch (NullPointerException n){
            n.getMessage();
        }

        return save;
        // return correlationFieldExist.get();
    }
}
