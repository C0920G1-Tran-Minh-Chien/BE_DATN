
package com.backend.pharmacy_management.model.service.import_bill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.service.IGeneralService;

import java.util.List;

public interface IImportBillDrugService   extends IGeneralService<ImportBillDrug> {
    List<ImportBillDrug> findAllImportBill();

    ImportBillDrug findDrugByid(Long id);

    List<ImportBillDrug> getAllImportBillDrugByManufacuterId(Long id);

    void updateImportBillDrug(Long id);
}

