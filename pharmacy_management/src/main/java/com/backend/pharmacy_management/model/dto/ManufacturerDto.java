
package com.backend.pharmacy_management.model.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class ManufacturerDto {
    private Long manufacturerId;
    @NotBlank(message = " Not Null")
    private String manufacturerCode;
    @NotBlank(message = " Not Null")
    private String manufacturerName;
    @NotBlank(message = " Not Null")
    private String manufacturerAddress;
    @NotBlank(message = " Not Null")
    @Email(message = "Enter the correct format")
    private String manufacturerEmail;
    @NotBlank(message = " Not Null")
    @Pattern(regexp = "^\\+84[0-9]{8,9}|0[0-9]{8,9}$")
    private String manufacturerPhoneNumber;
    private double manufacturerDebts;
    @NotBlank(message = " Not Null")
    private String manufacturerNote ;
    private Integer flag;


    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerAddress() {
        return manufacturerAddress;
    }

    public void setManufacturerAddress(String manufacturerAddress) {
        this.manufacturerAddress = manufacturerAddress;
    }

    public String getManufacturerEmail() {
        return manufacturerEmail;
    }

    public void setManufacturerEmail(String manufacturerEmail) {
        this.manufacturerEmail = manufacturerEmail;
    }

    public String getManufacturerPhoneNumber() {
        return manufacturerPhoneNumber;
    }

    public void setManufacturerPhoneNumber(String manufacturerPhoneNumber) {
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
    }

    public double getManufacturerDebts() {
        return manufacturerDebts;
    }

    public void setManufacturerDebts(double manufacturerDebts) {
        this.manufacturerDebts = manufacturerDebts;
    }

    public String getManufacturerNote() {
        return manufacturerNote;
    }

    public void setManufacturerNote(String manufacturerNote) {
        this.manufacturerNote = manufacturerNote;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}

