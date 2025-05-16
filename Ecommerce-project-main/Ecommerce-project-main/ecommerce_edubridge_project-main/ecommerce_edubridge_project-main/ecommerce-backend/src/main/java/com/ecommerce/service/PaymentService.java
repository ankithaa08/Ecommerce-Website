package com.ecommerce.service;

import com.ecommerce.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getPaymentsByUserId(Long userId);
    List<Payment> getAllPayments();
    void deletePayment(Long id);
}