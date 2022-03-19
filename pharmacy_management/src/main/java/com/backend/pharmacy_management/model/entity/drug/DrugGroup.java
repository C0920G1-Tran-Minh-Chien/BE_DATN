package com.backend.pharmacy_management.model.entity.drug;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name="drug_group")
@Table
public class DrugGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugGroupId;
    @Column(unique = true)
    private String drugGroupCode;
    private String drugGroupName;
    @OneToMany(mappedBy = "drugGroup")
    @JsonBackReference(value = "drug_group-drug")
    private List<Drug> drugs;
    private boolean flag;
    public Long getDrugGroupId() {
        return drugGroupId;
    }

    public void setDrugGroupId(Long drugGroupId) {
        this.drugGroupId = drugGroupId;
    }

    public String getDrugGroupCode() {
        return drugGroupCode;
    }

    public void setDrugGroupCode(String drugGroupCode) {
        this.drugGroupCode = drugGroupCode;
    }

    public String getDrugGroupName() {
        return drugGroupName;
    }

    public void setDrugGroupName(String drugGroupName) {
        this.drugGroupName = drugGroupName;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
