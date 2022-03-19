
package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    Long paymentId ;
    @NotNull
    @Min(0)
    Double totalMoney ;
    @NotNull
    @Min(0)
    Double prepayment ;
    @NotNull
    @Min(0)
    Integer discount ;
    String status ;
    ImportBill importBill;
}
