package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.PaymentDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.Payment;
import com.backend.pharmacy_management.model.service.import_bill.IPaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/payments")
public class PaymentRestController {
    private final IPaymentService paymentService;

    public PaymentRestController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> payments = paymentService.findAllNormal();
        if (payments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @PostMapping(value= "", consumes={"application/json"})
    public ResponseEntity<Payment> create(@Valid @RequestBody PaymentDto paymentDto) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDto, payment);
        this.paymentService.save(payment);
        return new ResponseEntity<>(payment,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> getPayments(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.findById(id);
        return payment.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Payment> update(@Valid @RequestBody PaymentDto paymentDto, @PathVariable Long id) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDto, payment);
        this.paymentService.save(payment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
