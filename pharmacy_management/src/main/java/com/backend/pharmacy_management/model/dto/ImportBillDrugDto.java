
package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.dto.validatior.DateNotInPast;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportBillDrugDto {
    Long importBillDrugId;
    @NotNull
    @Min(0)
    Integer importAmount;
    @NotNull
    @Min(0)
    Double importPrice;
    @NotNull
    @Min(0)
    Integer discountRate;
    @NotNull
    Integer lotNumber;
    @NotNull
    @DateNotInPast
    LocalDate expiry;
    @NotNull
    Integer vat;
    boolean flag = true;
    @NotNull
    ImportBill importBill;
    @NotNull
    Drug drug;
}
