package com.backend.pharmacy_management.model.entity.bill_sale;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drug_of_bill")
public class DrugOfBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_of_bill_id")
    private Long drugOfBillId;
    @ManyToOne
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug;
    @ManyToOne
    @JoinColumn(name = "bill_sale_id", nullable = false)
    private BillSale billSale;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

}
