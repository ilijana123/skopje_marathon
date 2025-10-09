package com.example.skopje_marathon.controller;


import com.example.skopje_marathon.dto.PaymentRequest;
import com.example.skopje_marathon.dto.PaymentResponse;
import com.example.skopje_marathon.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process/{raceId}")
    public ResponseEntity<PaymentResponse> processPayment(
            @PathVariable Long raceId,
            @RequestBody PaymentRequest request) {
        try {
            PaymentResponse response = paymentService.processPayment(raceId, request.getTransactionId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            PaymentResponse errorResponse = new PaymentResponse();
            errorResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
