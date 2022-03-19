package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.voucher.Voucher;
import com.backend.pharmacy_management.model.service.cart.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VoucherController {
    @Autowired
    IVoucherService iVoucherService;


    @GetMapping("/cart/voucher")
    public ResponseEntity<List<Voucher>> getAllDrugGroups() {
        List<Voucher> voucherList = this.iVoucherService.findAll();
        if (voucherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(voucherList, HttpStatus.OK);
    }

    //        for (String id : listId.split(",")) {
//            Optional<Voucher> voucherOptional = this.iVoucherService.findById(Long.parseLong(id));
//            if (!voucherOptional.isPresent()) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//            this.iVoucherService.remove(Long.parseLong(id));
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
    @GetMapping("cart/voucher/delete/{listId}")
    public ResponseEntity<Voucher> deleteCustomer(@PathVariable Long[] listId) {
        for (int i = 0; i < listId.length; i++) {
            Optional<Voucher> voucherOptional = this.iVoucherService.findById(listId[i]);
            if (!voucherOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            this.iVoucherService.remove(listId[i]);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
