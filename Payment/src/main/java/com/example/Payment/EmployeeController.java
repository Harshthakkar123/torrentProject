package com.example.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    PaymentService paymentService;
    @CrossOrigin(origins = "*")
    @PostMapping(value="",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addEmployee(@RequestBody EmployeeModel ftpServer){
        try{
            paymentService.addEmployee(ftpServer);
            return "Added Sucessfull";
        }catch (Exception e){
            return null;
        }
    }
}
