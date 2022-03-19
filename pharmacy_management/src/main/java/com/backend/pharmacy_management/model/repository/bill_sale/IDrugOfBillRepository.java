
package com.backend.pharmacy_management.model.repository.bill_sale;
import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDrugOfBillRepository extends JpaRepository<DrugOfBill, Long> {
    @Query(value = "select * from  drug_of_bill d join bill_sale b on b.bill_sale_id = d.bill_sale_id where concat(b.bill_sale_code , b.bill_sale_id) = ?", nativeQuery = true)
    List<DrugOfBill> findAllDrugOfBillByBillSaleId(String id);

    @Query(value = "select * from  drug_of_bill   where prescription_id = ? ;", nativeQuery = true)
    List<DrugOfBill> findAllDrugOfBill(Long id);
}

