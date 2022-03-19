package com.backend.pharmacy_management.model.dto;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PrescriptionDto {
    private Long prescriptionId;
    @NotBlank(message = "Not blank")
    private String prescriptionCode;
    @NotBlank(message = "Not blank")
    private String prescriptionName;
    @NotBlank(message = "Not blank")
    private String symptom;
    @NotBlank(message = "Not blank")
    private String object;
    @NotNull(message = "Not null")
    private int numberOfDay;
    private  String note;
    private List<Indicative> indicatives;

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public PrescriptionDto() {
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        this.prescriptionCode = prescriptionCode;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Indicative> getIndicatives() {
        return indicatives;
    }

    public void setIndicatives(List<Indicative> indicatives) {
        this.indicatives = indicatives;
    }
}
