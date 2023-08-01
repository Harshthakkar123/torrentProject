package com.example.Payment;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Payment_data")
public class PaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "custName")
    private String name;


    @Column(name = "status")
    private String status;

    @Column(name = "cust_no")
    private Integer customerNo;

    @Column(name = "cust_email")
    private String customerEmail;
}
