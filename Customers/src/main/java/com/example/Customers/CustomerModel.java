package com.example.Customers;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Cutsomer_data")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "status")
    private String status;

    @Column(name = "cust_no")
    private Integer customerNo;

    @Column(name = "cust_email")
    private String customerEmail;


}
