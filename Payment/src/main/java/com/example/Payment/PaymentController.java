package com.example.Payment;


import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ftp-listen")
public class PaymentController {
    @Autowired
    PaymentService customerService;


    @CrossOrigin(origins = "*")
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addFtpServer(@RequestBody PaymentDto ftpServer) {
        try {
            customerService.addFtpServer(ftpServer);
            return "Added Sucessfull";
        } catch (Exception e) {
            return null;
        }
    }
//





}
