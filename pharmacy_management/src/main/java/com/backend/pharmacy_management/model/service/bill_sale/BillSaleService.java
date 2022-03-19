
package com.backend.pharmacy_management.model.service.bill_sale;


import com.backend.pharmacy_management.model.dto.BillSaleDto;
import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.repository.bill_sale.IBillSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillSaleService implements IBillSaleService {
    @Autowired
    IBillSaleRepository iBillSaleRepository;
    @Override
    public BillSale findBillSaleByIdCode(String id) {
        return iBillSaleRepository.findBillSaleByIdCode(id);
    }

    @Override
    public void save(BillSale billSale) {
        iBillSaleRepository.save(billSale);
    }

    @Override
    public void remove(Long id) {
        iBillSaleRepository.deleteById(id);
    }

    @Override
    public BillSaleDto findBIll() {
        return this.iBillSaleRepository.findBIllNew();
    }
}

