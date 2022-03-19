package com.backend.pharmacy_management.model.entity.drug;


import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
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
@Table(name="drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Long drugId;
    private Long drugCode;
    private String drugName;
    private String activeElement;
    private String unit;
    private String conversionUnit;
    private Integer conversionRate;
    private Double wholesaleProfitRate;
    private Double retailProfitRate;
    private String drugFaculty;
    @Column(columnDefinition = "TEXT")
    private String drugSideEffect;
    private Boolean flag = true;
    private String manufacturer;
    private String origin;
    private String note;
    @OneToMany(mappedBy = "drug")
    @JsonBackReference(value = "drug_of_bill-drug")
    private List<DrugOfBill> drugOfBills;
    @OneToMany(mappedBy = "drug")
    @JsonBackReference(value = "indicatives_drug-drug")
    private List<Indicative> indicatives;
    @OneToMany(mappedBy = "drug")
    @JsonBackReference(value = "import_bill_drug-drug")
    private List<ImportBillDrug> importBillDrugs;
    @ManyToOne
    @JoinColumn(name = "drug_group_id")
    private DrugGroup drugGroup;
    @OneToMany(targetEntity = DrugImageDetail.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "drug_id", referencedColumnName = "drug_id")
    @JsonBackReference(value = "drug_image_detail-drug")
    private List<DrugImageDetail> drugImageDetails;

}
