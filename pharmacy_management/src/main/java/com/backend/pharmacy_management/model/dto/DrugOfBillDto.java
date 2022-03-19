package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DrugOfBillDto {
    private Long drugOfBillId;
    private Drug drug;
    private BillSale billSale;
    private int quantity;
    private Prescription prescription;

}
