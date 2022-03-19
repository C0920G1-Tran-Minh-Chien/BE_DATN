package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long paymentId ;
    Double totalMoney ;
    Double prepayment ;
    Integer discount ;
    String status ;
    @OneToOne(mappedBy = "payment")
    @JsonBackReference(value = "payment-import_bill")
    ImportBill importBill;

    public Payment() {
    }

    public Payment(Long paymentId, Double totalMoney, Double prepayment, Integer discount, String status, ImportBill importBill) {
        this.paymentId = paymentId;
        this.totalMoney = totalMoney;
        this.prepayment = prepayment;
        this.discount = discount;
        this.status = status;
        this.importBill = importBill;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(Double prepayment) {
        this.prepayment = prepayment;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImportBill(ImportBill importBill) {
        this.importBill = importBill;
    }
}
