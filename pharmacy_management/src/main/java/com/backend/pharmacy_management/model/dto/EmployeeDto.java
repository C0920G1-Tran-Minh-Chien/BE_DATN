package com.backend.pharmacy_management.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EmployeeDto {
    private Long employeeId;
    private String employeeCode;
    @NotBlank(message = "Trường này không được để trống.")
    @Size(min = 6,message = "Nhập tối thiểu 6 ký tự.")
    private String employeeName;
    @NotBlank(message = "Trường này không được để trống.")
    private String employeeAddress;
    private String employeeImage;
    @NotBlank(message = "Trường này không được để trống.")
    private String employeePhone;
    private String employeeStartDate;
    @Size(max = 250, message = "Nhập tối đa 250 ký tự.")
    private String employeeNote;
    private String position;
    @NotBlank(message = "Trường này không được để trống.")
    @Size(min = 6,max = 50,message = "Nhập tối thiểu 6 ký tự,tối đa 50 ký tự")
    private String accountName;


    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

}
