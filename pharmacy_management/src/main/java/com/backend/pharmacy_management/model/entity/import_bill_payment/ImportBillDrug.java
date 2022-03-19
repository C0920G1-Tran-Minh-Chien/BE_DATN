package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "import_bill_drug")
public class ImportBillDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long importBillDrugId;
    Integer importAmount;
    Double importPrice;
    Integer discountRate;
    Integer lotNumber;
    LocalDate expiry;
    Integer vat;
    boolean flag = true;
    @ManyToOne
    @JoinColumn(name = "import_bill_id")
    ImportBill importBill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    Drug drug;
    @OneToOne(mappedBy = "importBillDrug")
    @JsonIgnore
    private ExportBillDetail exportBillDetail;
}
