package com.backend.pharmacy_management.model.dto;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class ExportBillDetailDto implements Validator {
    private Long exportBillDetailId;
    @NotNull
    private ExportBill exportBill;
    @NotNull
    private ImportBillDrug importBillDrug;

    public ExportBillDetailDto() {
        // Hàm không tham số
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        // Không validate custom
    }
}
