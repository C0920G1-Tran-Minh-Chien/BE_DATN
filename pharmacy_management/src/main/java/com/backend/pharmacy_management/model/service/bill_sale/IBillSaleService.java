
package com.backend.pharmacy_management.model.service.bill_sale;
import com.backend.pharmacy_management.model.dto.BillSaleDto;
import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;

public interface IBillSaleService {
    BillSale findBillSaleByIdCode(String id);
    void save(BillSale billSale);
    void remove(Long id);

    BillSaleDto findBIll();
}