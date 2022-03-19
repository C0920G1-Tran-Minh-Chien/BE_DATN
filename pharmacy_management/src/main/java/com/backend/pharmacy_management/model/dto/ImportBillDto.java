
package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.import_bill_payment.Payment;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportBillDto {
    private Long importBillId;
    @NotNull
    @Pattern(regexp = "^HD[\\w]+",message = "import system code must start with HD ")
    private String importSystemCode;
    @NotNull
    private String accountingVoucher;
    @NotNull
    private String invoiceDate;
    private Boolean flag = true;
    @NotNull
    private  Payment payment;
    @NotNull
    private Manufacturer manufacturer;
    @NotNull
    private Employee employee;

}