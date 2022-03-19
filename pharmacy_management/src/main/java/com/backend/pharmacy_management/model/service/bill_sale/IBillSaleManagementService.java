package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBillSaleManagementService {
    List<BillSale> findAllBill();
    Optional<BillSale> findBillSaleById(Long id);

    Page<BillSale> findAllBillPage(Pageable pageable);

    void deleteBillById(Long id);
    List<BillSale> findBillBySearch(String search1, String search2, String search3, String search4, String search5);
    List<BillSale> findBillBySearch1(String search1, String search2, String search3, String search4, String search5);
    List<BillSale> findBillBySearch2(String search1, String search2, String search3, String search4, String search5);
    List<BillSale> findBillBySearch3(String search1, String search2, String search3, String search4, String search5);
    List<BillSale> findBillBySearch4(String search1, String search2, String search3, String search4, String search5);
    List<BillSale> findBillBySearch5(String search1, String search2, String search3, String search4, String search5);




    Page<BillSale> findBillBySearchPage(String search1, String search2, String search3, String search4, String search5, Pageable pageable);
    Page<BillSale> findBillBySearchPage1(String search1, String search2, String search3, String search4, String search5,Pageable pageable);
    Page<BillSale> findBillBySearchPage2(String search1, String search2, String search3, String search4, String search5,Pageable pageable);
    Page<BillSale> findBillBySearchPage3(String search1, String search2, String search3, String search4, String search5,Pageable pageable);
    Page<BillSale> findBillBySearchPage4(String search1, String search2, String search3, String search4, String search5,Pageable pageable);
    Page<BillSale> findBillBySearchPage5(String search1, String search2, String search3, String search4, String search5,Pageable pageable);

}
