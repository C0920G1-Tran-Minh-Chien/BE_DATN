package com.backend.pharmacy_management.model.service.customer;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAllNormal() {
        return iCustomerRepository.findAll();
    }


    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }





    @Override
    public List<Customer> getAllCustomer() {
        return this.iCustomerRepository.getAllCustomer();
    }

    @Override
    public List<Customer> getCustomerPagination(int index) {
        return this.iCustomerRepository.getCustomerPagination(index);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return this.iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> findCustomerBySearch( String keyWord) {
        return this.iCustomerRepository.findCustomerBySearch(keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerCode(int index,String keyWord) {
        return this.iCustomerRepository.findCustomerByCustomerCode(index,keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerGroup(int index,String keyWord) {
        return this.iCustomerRepository.findCustomerByCustomerGroup(index,keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerName(int index,String keyWord) {
        return this.iCustomerRepository.findCustomerByCustomerName(index,keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerAddress(int index,String keyWord) {
        return this.iCustomerRepository.findCustomerByCustomerAddress(index,keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerPhone(int index,String keyWord) {
        return this.iCustomerRepository.findCustomerByCustomerPhone(index,keyWord);
    }

    @Override
    public Integer findNumberOfRecordCustomerCode(String keyWord) {
        return this.iCustomerRepository.findNumberOfRecordCustomerCode(keyWord);
    }

    @Override
    public Integer findNumberOfRecordCustomerName(String keyWord) {
        return this.iCustomerRepository.findNumberOfRecordCustomerName(keyWord);
    }

    @Override
    public Integer findNumberOfRecordCustomerAddress(String keyWord) {
        return this.iCustomerRepository.findNumberOfRecordCustomerAddress(keyWord);
    }

    @Override
    public Integer findNumberOfRecordCustomerPhone(String keyWord) {
        return this.iCustomerRepository.findNumberOfRecordCustomerPhone(keyWord);
    }

    @Override
    public List<Customer> getAllCustomerWholeSale() {
        return this.iCustomerRepository.getAllCustomerWholeSale();
    }
}
