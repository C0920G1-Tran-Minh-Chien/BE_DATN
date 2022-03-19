package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.repository.bill_sale.IBillSaleManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BillSaleManagementService implements IBillSaleManagementService {
@Autowired
private IBillSaleManagementRepository billSaleManagementRepository;
    @Override
    public List<BillSale> findAllBill() {
        return billSaleManagementRepository.findAllBill();
    }

    @Override
    public Optional<BillSale> findBillSaleById(Long id) {
        return billSaleManagementRepository.findBillSaleById(id);
    }

    @Override
    public Page<BillSale> findAllBillPage(Pageable pageable) {
        return billSaleManagementRepository.findAllBillPage(pageable);
    }

    @Override
    public void deleteBillById(Long id) {
        billSaleManagementRepository.deleteBillById(id);

    }

    @Override
    public List<BillSale> findBillBySearch(String search1, String search2, String search3, String search4, String search5) {
        return billSaleManagementRepository.findBillBySearch(search1,search2,search3,search4,search5);
    }

    @Override
    public List<BillSale> findBillBySearch1(String search1, String search2, String search3, String search4, String search5) {
        return billSaleManagementRepository.findBillBySearch1(search1,search2,search3,search4,search5);
    }

    @Override
    public List<BillSale> findBillBySearch2(String search1, String search2, String search3, String search4, String search5) {
        return billSaleManagementRepository.findBillBySearch2(search1,search2,search3,search4,search5);
    }

    @Override
    public List<BillSale> findBillBySearch3(String search1, String search2, String search3, String search4, String search5) {
        return billSaleManagementRepository.findBillBySearch3(search1,search2,search3,search4,search5);
    }

    @Override
    public List<BillSale> findBillBySearch4(String search1, String search2, String search3, String search4, String search5) {
        return billSaleManagementRepository.findBillBySearch4(search1,search2,search3,search4,search5);
    }

    @Override
    public List<BillSale> findBillBySearch5(String search1, String search2, String search3, String search4, String search5) {
        return billSaleManagementRepository.findBillBySearch5(search1,search2,search3,search4,search5);
    }

    @Override
    public Page<BillSale> findBillBySearchPage(String search1, String search2, String search3, String search4, String search5, Pageable pageable) {
        return billSaleManagementRepository.findBillBySearchPage(search1,search2,search3,search4,search5,pageable);
    }

    @Override
    public Page<BillSale> findBillBySearchPage1(String search1, String search2, String search3, String search4, String search5, Pageable pageable) {
        return billSaleManagementRepository.findBillBySearchPage1(search1,search2,search3,search4,search5,pageable);
    }

    @Override
    public Page<BillSale> findBillBySearchPage2(String search1, String search2, String search3, String search4, String search5, Pageable pageable) {
        return billSaleManagementRepository.findBillBySearchPage2(search1,search2,search3,search4,search5,pageable);
    }

    @Override
    public Page<BillSale> findBillBySearchPage3(String search1, String search2, String search3, String search4, String search5, Pageable pageable) {
        return billSaleManagementRepository.findBillBySearchPage3(search1,search2,search3,search4,search5,pageable);
    }

    @Override
    public Page<BillSale> findBillBySearchPage4(String search1, String search2, String search3, String search4, String search5, Pageable pageable) {
        return billSaleManagementRepository.findBillBySearchPage4(search1,search2,search3,search4,search5,pageable);
    }

    @Override
    public Page<BillSale> findBillBySearchPage5(String search1, String search2, String search3, String search4, String search5, Pageable pageable) {
        return billSaleManagementRepository.findBillBySearchPage5(search1,search2,search3,search4,search5,pageable);
    }


}
