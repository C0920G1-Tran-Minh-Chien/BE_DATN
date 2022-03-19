package com.backend.pharmacy_management.controller.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.service.bill_sale.IBillSaleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/api/bill")
public class BillSaleManagementController {
    @Autowired
    private IBillSaleManagementService billSaleManagementService;
    @GetMapping()
    public ResponseEntity<Page<BillSale>> findAllBillPage(@RequestParam Integer page) {
        Page<BillSale> billList = billSaleManagementService.findAllBillPage(PageRequest.of(page,5));
        if (billList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<BillSale>> findBillBySearch(@RequestParam("search1") Optional<String> search1, @RequestParam("search2") Optional<String> search2,
                                                           @RequestParam("search3") Optional<String> search3, @RequestParam("search4") Optional<String> search4,
                                                           @RequestParam("search5") Optional<String> search5,
                                                           @RequestParam("search6") Optional<String> search6,
                                                           @RequestParam Integer page

    ) {

        Page<BillSale> billList;
        String sort = search6.get();
        switch (sort) {
            case "" :
                billList = billSaleManagementService.findBillBySearchPage(search1.get(), search2.get(), search3.get(), search4.get(), search5.get(),PageRequest.of(page,5));
                break;
            case "1":
                billList = billSaleManagementService.findBillBySearchPage1(search1.get(), search2.get(), search3.get(), search4.get(), search5.get(),PageRequest.of(page,5));
                break;
            case "2":
                billList = billSaleManagementService.findBillBySearchPage2(search1.get(), search2.get(), search3.get(), search4.get(), search5.get(),PageRequest.of(page,5));
                break;
            case "3":
                billList = billSaleManagementService.findBillBySearchPage3(search1.get(), search2.get(), search3.get(), search4.get(), search5.get(),PageRequest.of(page,5));
                break;
            case "4":
                billList = billSaleManagementService.findBillBySearchPage4(search1.get(), search2.get(), search3.get(), search4.get(), search5.get(),PageRequest.of(page,5));
                break;
            case "5":
                billList = billSaleManagementService.findBillBySearchPage5(search1.get(), search2.get(), search3.get(), search4.get(), search5.get(),PageRequest.of(page,5));
                break;

            default:
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(billList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BillSale> findBillById(@PathVariable Long id) {
        Optional<BillSale> billOptional = billSaleManagementService.findBillSaleById(id);
        if (!billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billOptional.get(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> deleteBillById(@PathVariable Long id) {
        billSaleManagementService.deleteBillById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
