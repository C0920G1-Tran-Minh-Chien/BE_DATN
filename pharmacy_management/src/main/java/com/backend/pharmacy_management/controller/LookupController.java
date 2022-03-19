package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.service.lookup.ILookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LookupController {
    @Autowired
    ILookupService iLookupService;

    @GetMapping("customer/search")
    public ResponseEntity<Page<Customer>> findALlByKey(@RequestParam Optional<String> keyWord1,
                                                       @RequestParam Optional<String> attribute,
                                                       @RequestParam Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<Customer> customers = null;
        String keyWord = "%" + keyWord1.orElse("")       + "%";
        switch (attribute.orElse("")) {
            case "code":
                customers = iLookupService.findALlCusByKey(keyWord, "%%", "%%", "%%", "%%", pageable);
                break;
            case "name":
                customers = iLookupService.findALlCusByKey("%%", keyWord, "%%", "%%", "%%", pageable);
                break;
            case "address":
                customers = iLookupService.findALlCusByKey("%%", "%%", keyWord, "%%", "%%", pageable);
                break;
            case "phone":
                customers = iLookupService.findALlCusByKey("%%", "%%", "%%", keyWord, "%%", pageable);
                break;
            case "groupId":
                customers = iLookupService.findALlCusByKey("%%", "%%", "%%", "%%", keyWord, pageable);
                break;
            case "all":
                customers = iLookupService.findALlCustomersByKey(keyWord, keyWord, keyWord, keyWord, keyWord, pageable);
                break;
            default:
                error();
                break;
        }
        if (customers == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("customer_group")
    public ResponseEntity<List<CustomerGroup>> findAllCustomerGroup() {
        List<CustomerGroup> customerGroups = iLookupService.findAllCustomerGroup();
        if (customerGroups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerGroups, HttpStatus.OK);
    }

    private void error() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("manufacturer/search")
    public ResponseEntity<Page<Manufacturer>> findManuALlByKey(@RequestParam Optional<String> keyWord1,
                                                               @RequestParam Optional<String> attribute,
                                                               @RequestParam Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<Manufacturer> manufacturers = null;
        String keyWord = "%" + keyWord1.orElse("") + "%";
        switch (attribute.orElse("")) {
            case "code":
                manufacturers = iLookupService.findManufacturerByKey(keyWord, "%%", "%%", "%%", pageable);
                break;
            case "name":
                manufacturers = iLookupService.findManufacturerByKey("%%", keyWord, "%%", "%%", pageable);
                break;
            case "address":
                manufacturers = iLookupService.findManufacturerByKey("%%", "%%", keyWord, "%%", pageable);
                break;
            case "phone":
                manufacturers = iLookupService.findManufacturerByKey("%%", "%%", "%%", keyWord, pageable);
                break;
            case "all":
                manufacturers = iLookupService.findAllManufacturerByKey(keyWord, keyWord, keyWord, keyWord, pageable);
                break;
            default:
                error();
                break;
        }
        if (manufacturers == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(manufacturers, HttpStatus.OK);
    }


}
