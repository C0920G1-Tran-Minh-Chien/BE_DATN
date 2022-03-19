
package com.backend.pharmacy_management.model.repository.import_bill;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImportBillDrugRepository extends JpaRepository<ImportBillDrug,Long> {
    @Query(value = "SELECT im.* \n" +
            "FROM manufacturer  as mn  join import_bill as imb \n" +
            "on mn.manufacturer_id = imb.manufacturer_id join import_bill_drug as im\n" +
            "on imb.import_bill_id =  im.import_bill_id  join drug \n" +
            "on drug.drug_id = im.drug_id\n" +
            "where mn.manufacturer_id = ? and im.flag=1", nativeQuery = true)
    List<ImportBillDrug> getAllImportBillDrugByManufacuterId(Long id);

    @Query(value = "select * from import_bill_drug d where d.import_amount > 0 && d.flag=1", nativeQuery = true)
    List<ImportBillDrug> getAll();

}

