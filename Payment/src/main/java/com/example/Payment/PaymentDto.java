package com.example.Payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private Long id;

    private String name;

    private String status;

    private Integer customerNo;

    private String customerEmail;

    private Boolean flag;
}
