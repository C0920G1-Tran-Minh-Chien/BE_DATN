package com.backend.pharmacy_management.model.dto;
import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;
import java.util.List;

public class CreateDrugDto implements Validator {
    private Long drugId;
    @NotBlank
    @Size(max = 25)
    private String drugName;
    @NotBlank
    @Size(max = 50)
    private String activeElement;
    @NotBlank
    private String unit;
    @NotBlank
    private String conversionUnit;
    @NotNull
    @Min(value = 1)
    @NumberFormat(pattern = "^[1-9]\\d*$")
    private Integer conversionRate;
    @NotNull
    @Min(0)
    @NumberFormat(pattern = "^\\d*\\.?\\d*$")
    private Double wholesaleProfitRate;
    @Min(0)
    @NumberFormat(pattern = "/^\\d*\\.?\\d*$/")
    private Double retailProfitRate;
//    @NotNull
    private List<DrugImageDetail> drugImageDetails;
    @NotBlank
    @Size(max = 50)
    private String drugFaculty;
    @Size(max = 25)
    private String manufacturer;
    @NotBlank
    private String origin;
    @Size(max = 250)
    private String note;
    @NotNull
    private DrugGroup drugGroup;
    @NotBlank
    @Size(max = 50)
    private String drugSideEffect;
    
    private String img;

    public CreateDrugDto() {
//        contructor
    }

    public List<DrugImageDetail> getDrugImageDetails() {
        return drugImageDetails;
    }

    public void setDrugImageDetails(List<DrugImageDetail> drugImageDetails) {
        this.drugImageDetails = drugImageDetails;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getActiveElement() {
        return activeElement;
    }

    public void setActiveElement(String activeElement) {
        this.activeElement = activeElement;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getConversionUnit() {
        return conversionUnit;
    }

    public void setConversionUnit(String conversionUnit) {
        this.conversionUnit = conversionUnit;
    }

    public Integer getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Integer conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Double getWholesaleProfitRate() {
        return wholesaleProfitRate;
    }

    public void setWholesaleProfitRate(Double wholesaleProfitRate) {
        this.wholesaleProfitRate = wholesaleProfitRate;
    }

    public Double getRetailProfitRate() {
        return retailProfitRate;
    }

    public void setRetailProfitRate(Double retailProfitRate) {
        this.retailProfitRate = retailProfitRate;
    }

    public String getDrugFaculty() {
        return drugFaculty;
    }

    public void setDrugFaculty(String drugFaculty) {
        this.drugFaculty = drugFaculty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDrugSideEffect() {
        return drugSideEffect;
    }

    public void setDrugSideEffect(String drugSideEffect) {
        this.drugSideEffect = drugSideEffect;
    }

    public DrugGroup getDrugGroup() {
        return drugGroup;
    }

    public void setDrugGroup(DrugGroup drugGroup) {
        this.drugGroup = drugGroup;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        CreateDrugDto createDrugDto = (CreateDrugDto) target;
//        Double wholesaleProfitRate = createDrugDto.getWholesaleProfitRate();
//        ValidationUtils.rejectIfEmpty(errors,"wholesaleProfitRate","");
    }
}
