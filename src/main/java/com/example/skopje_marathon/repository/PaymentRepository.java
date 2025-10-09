package com.example.skopje_marathon.repository;

import com.example.skopje_marathon.model.Payment;
import com.example.skopje_marathon.enumeration.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByTransactionId(String transactionId);
}