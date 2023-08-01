package com.example.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ftp-listeners")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @CrossOrigin(origins = "*")
    @PostMapping(value="",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addFtpServer(@RequestBody PaymentDto ftpServer){
        try{
            customerService.addFtpServer(ftpServer);
            return "Added Sucessfull";
        }catch (Exception e){
            return null;
        }
    }
}
