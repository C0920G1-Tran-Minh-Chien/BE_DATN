package com.backend.pharmacy_management.controller;
import com.backend.pharmacy_management.model.dto.CustomerDto;
import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.service.customer.ICustomerService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/search/{keyWord}")
    public ResponseEntity<List<Customer>> findCustomerBySearch(@PathVariable String keyWord) {
        List<Customer> customers = iCustomerService.findCustomerBySearch(keyWord);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
    @GetMapping("/searchField/customerCode/{index}/{keyWord}")
    public ResponseEntity<List<Customer>> findCustomerByCustomerCode(@PathVariable int index, @PathVariable String keyWord) {
        List<Customer> customers=iCustomerService.findCustomerByCustomerCode(index,keyWord);
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
    @GetMapping("/searchField/customerGroup/{index}/{keyWord}")
    public ResponseEntity<List<Customer>> findCustomerByCustomerGroup(@PathVariable int index,@PathVariable String keyWord) {
        List<Customer> customers=iCustomerService.findCustomerByCustomerGroup(index,keyWord);
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
    @GetMapping("/searchField/customerName/{index}/{keyWord}")
    public ResponseEntity<List<Customer>> findCustomerByCustomerName(@PathVariable int index,@PathVariable String keyWord) {
        List<Customer> customers=iCustomerService.findCustomerByCustomerName(index,keyWord);
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
    @GetMapping("/searchField/customerAddress/{index}/{keyWord}")
    public ResponseEntity<List<Customer>> findCustomerByCustomerAddress(@PathVariable int index,@PathVariable String keyWord) {
        List<Customer> customers=iCustomerService.findCustomerByCustomerAddress(index,keyWord);
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
    @GetMapping("/searchField/customerPhone/{index}/{keyWord}")
    public ResponseEntity<List<Customer>> findCustomerByCustomerPhone(@PathVariable int index,@PathVariable String keyWord) {
        List<Customer> customers=iCustomerService.findCustomerByCustomerPhone(index,keyWord);
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer customer = this.iCustomerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        Customer customer1 = this.iCustomerService.findCustomerById(id);
        if (customer1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerDto.setCustomerId(id);
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            this.iCustomerService.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(@RequestParam int index) {
        List<Customer> customers = iCustomerService.getCustomerPagination(index);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = iCustomerService.getAllCustomer();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
    @GetMapping("/getNumberOfRecordCode/{keyword}")
    public ResponseEntity<Integer> getNumberOfRecordCode(@PathVariable String keyword){
        Integer integer = this.iCustomerService.findNumberOfRecordCustomerCode(keyword);
        return new ResponseEntity<>(integer,HttpStatus.OK);
    }

    @GetMapping("/getNumberOfRecordName/{keyword}")
    public ResponseEntity<Integer> getNumberOfRecordName(@PathVariable String keyword){
        Integer integer = this.iCustomerService.findNumberOfRecordCustomerName(keyword);
        return new ResponseEntity<>(integer,HttpStatus.OK);
    }
    @GetMapping("/getNumberOfRecordAddress/{keyword}")
    public ResponseEntity<Integer> getNumberOfRecordAddress(@PathVariable String keyword){
        Integer integer = this.iCustomerService.findNumberOfRecordCustomerAddress(keyword);
        return new ResponseEntity<>(integer,HttpStatus.OK);
    }
    @GetMapping("/getNumberOfRecordPhone/{keyword}")
    public ResponseEntity<Integer> getNumberOfRecordPhone(@PathVariable String keyword){
        Integer integer = this.iCustomerService.findNumberOfRecordCustomerPhone(keyword);
        return new ResponseEntity<>(integer,HttpStatus.OK);
    }

    @GetMapping("/customer-wholesale")
    public ResponseEntity<List<Customer>> getAllCustomerWholeSale() {
        List<Customer> customers = iCustomerService.getAllCustomerWholeSale();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
}
