package com.example.Payment;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employee_data")
public class EmployeeModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "address")
        private String address;

}
