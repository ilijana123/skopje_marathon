package com.example.skopje_marathon.service;

import com.example.skopje_marathon.dto.PaymentResponse;
import com.example.skopje_marathon.enumeration.PaymentStatus;
import com.example.skopje_marathon.enumeration.Status;
import com.example.skopje_marathon.model.*;
import com.example.skopje_marathon.repository.PaymentRepository;
import com.example.skopje_marathon.repository.RaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final RaceRepository raceRepository;
    private final Random random = new Random();

    public PaymentService(PaymentRepository paymentRepository, RaceRepository raceRepository) {
        this.paymentRepository = paymentRepository;
        this.raceRepository = raceRepository;
    }

    @Transactional
    public PaymentResponse processPayment(Long raceId, String transactionId) {
        Race race = raceRepository.findById(raceId)
                .orElseThrow(() -> new IllegalArgumentException("Race with id " + raceId + " does not exist"));

        if (race.getStatus() == Status.PAID) {
            throw new IllegalStateException("Race already paid");
        }

        Payment existingPayment = paymentRepository.findByTransactionId(transactionId).orElse(null);
        if (existingPayment != null) {
            return buildResponseFromPayment(existingPayment, race);
        }

        Payment payment = new Payment();
        payment.setTransactionId(transactionId);
        payment.setAmount(race.getCategory().getPrice());
        payment.setRace(race);
        payment = paymentRepository.save(payment);

        return simulatePaymentProcessing(payment, race);
    }

    private PaymentResponse simulatePaymentProcessing(Payment payment, Race race) {
        PaymentResponse response = new PaymentResponse();
        int attempts = 0;
        boolean isSuccess = false;

        while (attempts < 3 && !isSuccess) {
            attempts++;
            try {
                Thread.sleep(1000 + random.nextInt(2000));
                isSuccess = Math.random() < 0.5;

                if (isSuccess) {
                    Integer startNumber = generateStartNumber();
                    payment.setStatus(PaymentStatus.SUCCESS);
                    paymentRepository.save(payment);

                    race.setStartNumber(startNumber);
                    race.setStatus(Status.PAID);
                    raceRepository.save(race);

                    response.setStatus(PaymentStatus.SUCCESS);
                    response.setStartNumber(startNumber);
                    response.setRegistrationNumber(race.getRegistrationNumber());
                    response.setMessage("Payment successfully processed");
                } else if (attempts >= 3) {
                    payment.setStatus(PaymentStatus.FAILED);
                    paymentRepository.save(payment);
                    response.setRegistrationNumber(race.getRegistrationNumber());
                    response.setStatus(PaymentStatus.FAILED);
                    response.setMessage("Payment failed after retries");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                payment.setStatus(PaymentStatus.FAILED);
                paymentRepository.save(payment);

                response.setStatus(PaymentStatus.FAILED);
                response.setMessage("Error while processing the payment");
            }
        }
        return response;
    }

    private PaymentResponse buildResponseFromPayment(Payment payment, Race race) {
        PaymentResponse response = new PaymentResponse();
        response.setStatus(payment.getStatus());
        response.setRegistrationNumber(race.getRegistrationNumber());
        if (payment.getStatus() == PaymentStatus.SUCCESS) {
            response.setStartNumber(race.getStartNumber());
            response.setMessage("Payment already successful (idempotent response)");
        } else {
            response.setMessage("Payment previously failed (idempotent response)");
        }
        return response;
    }

    private Integer generateStartNumber() {
        return raceRepository
                .findTopByStatusOrderByStartNumberDesc(Status.PAID)
                .map(Race::getStartNumber)
                .orElse(0) + 1;
    }
}
