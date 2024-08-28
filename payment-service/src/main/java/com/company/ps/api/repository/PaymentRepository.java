package com.company.ps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ps.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment findByOrderId(int orderId);
}

