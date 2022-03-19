
package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;

import java.util.List;

public interface IDrugOfBillService {
    List<DrugOfBill> findAllDrugOfBillByBillSaleId(String id);
    void save(DrugOfBill drugOfBill);
    void remove(Long id);
    List<DrugOfBill> findAllDrugOfBill(Long id);
}