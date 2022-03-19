package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.drug.Drug;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DrugImageDetailDto {
    private Long drugImageDetailId;
    private String drugImageDetailUrl;
    private Drug drug;

    public DrugImageDetailDto() {
        //contructor
    }

    public Long getDrugImageDetailId() {
        return drugImageDetailId;
    }

    public void setDrugImageDetailId(Long drugImageDetailId) {
        this.drugImageDetailId = drugImageDetailId;
    }

    public String getDrugImageDetailUrl() {
        return drugImageDetailUrl;
    }

    public void setDrugImageDetailUrl(String drugImageDetailUrl) {
        this.drugImageDetailUrl = drugImageDetailUrl;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
