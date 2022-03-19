package com.backend.pharmacy_management.model.service.customer;

import com.backend.pharmacy_management.model.entity.customer.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findById(Long id);
    List<Customer> findAllNormal();
    void save(Customer customer);
    void remove(Long id);


    List<Customer> getAllCustomer();

    List<Customer> getCustomerPagination(int index);
    Customer findCustomerById(Long id);

    List<Customer> findCustomerBySearch(String keyWord);

    List<Customer> findCustomerByCustomerCode(int index,String keyWord);
    List<Customer> findCustomerByCustomerGroup(int index,String keyWord);
    List<Customer> findCustomerByCustomerName(int index,String keyWord);
    List<Customer> findCustomerByCustomerAddress(int index,String keyWord);
    List<Customer> findCustomerByCustomerPhone(int index,String keyWord);


    Integer findNumberOfRecordCustomerCode(String keyWord);
    Integer findNumberOfRecordCustomerName(String keyWord);
    Integer findNumberOfRecordCustomerAddress(String keyWord);
    Integer findNumberOfRecordCustomerPhone(String keyWord);

    List<Customer> getAllCustomerWholeSale();
}
