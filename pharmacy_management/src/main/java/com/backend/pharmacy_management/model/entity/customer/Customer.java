package com.backend.pharmacy_management.model.entity.customer;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerCode;
    private String customerName;
    private Integer customerAge;
    private String customerAddress;
    private String customerPhone;
    private String customerNote;
    private Boolean flag;

    public Customer(Long customerId) {
        this.customerId = customerId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_group_id")
    private CustomerGroup customerGroup;
    @OneToMany(mappedBy = "customer")
    @JsonBackReference(value = "customer-bill_sale")
    List<BillSale> billWholesales;

}