package com.example.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PaymentRepository extends JpaRepository<PaymentModel,Long> {

    PaymentModel findByCustomerNo(int id);
}
