package com.backend.pharmacy_management.model.dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class DrugGroupDto {
    private Long drugGroupId;
    @NotBlank
    @Pattern(regexp = "^(NT)[0-9]{3}$")
    private String drugGroupCode;
    @NotBlank
    @Size(max = 30)
    private String drugGroupName;
    private boolean flag = true;

    public DrugGroupDto() {
    }

    public DrugGroupDto(Long drugGroupId, String drugGroupCode, String drugGroupName, boolean flag) {
        this.drugGroupId = drugGroupId;
        this.drugGroupCode = drugGroupCode;
        this.drugGroupName = drugGroupName;
        this.flag = flag;
    }

    public void setDrugGroupId(Long drugGroupId) {
        this.drugGroupId = drugGroupId;
    }

    public Long getDrugGroupId() {
        return drugGroupId;
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
