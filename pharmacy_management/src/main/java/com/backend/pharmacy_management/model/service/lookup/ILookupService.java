package com.backend.pharmacy_management.model.service.lookup;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ILookupService {
    Page<Manufacturer> findManufacturerByKey (String code, String name, String address, String phone, Pageable pageable);
    Page<Customer> findALlCusByKey(String code, String name, String address, String phone, String groupId, Pageable pageable);
    Page<Manufacturer> findAllManufacturerByKey(String code, String name, String address, String phone, Pageable pageable);
    Page<Customer> findALlCustomersByKey (String code, String name, String address, String phone, String groupId, Pageable pageable);
    List<CustomerGroup> findAllCustomerGroup();
}
