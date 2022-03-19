package com.backend.pharmacy_management.model.entity.bill_sale;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bill_sale")
public class BillSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_sale_id")
    private Long billSaleId;
    private String billSaleCode;
    private String invoiceDate;
    private String billSaleNote;
    private String billSaleType;
    private Boolean flag = true;
    private double totalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "billSale")
    @JsonBackReference(value="drug_of_bill-bill_sale")
    private List<DrugOfBill> drugOfBills;

    public BillSale(String billSaleCode, String invoiceDate, String billSaleNote, String billSaleType, Boolean flag, double totalMoney, Employee employee, Customer customer) {
        this.billSaleCode = billSaleCode;
        this.invoiceDate = invoiceDate;
        this.billSaleNote = billSaleNote;
        this.billSaleType = billSaleType;
        this.flag = flag;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;

    }
}
