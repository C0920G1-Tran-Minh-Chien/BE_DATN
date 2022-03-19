package com.backend.pharmacy_management.model.service.lookup;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.repository.customer.ICustomerGroupRepository;
import com.backend.pharmacy_management.model.repository.customer.ICustomerRepository;
import com.backend.pharmacy_management.model.repository.manufacturer.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookupService implements ILookupService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Autowired
    ManufacturerRepository manufacturerRepository;
    @Autowired
    ICustomerGroupRepository iCustomerGroupRepository;

    @Override
    public Page<Manufacturer> findManufacturerByKey(String code, String name, String address, String phone, Pageable pageable) {
        return manufacturerRepository.findManufacturerByKey(code, name, address, phone, pageable);
    }

    @Override
    public Page<Manufacturer> findAllManufacturerByKey(String code, String name, String address, String phone, Pageable pageable) {
        return manufacturerRepository.findAllManufacturerByKey(code, name, address, phone, pageable);
    }

    @Override
    public Page<Customer> findALlCusByKey(String code, String name, String address, String phone, String groupId, Pageable pageable) {
        return iCustomerRepository.findALlCusByKey(code, name, address, phone, groupId, pageable);
    }

    @Override
    public Page<Customer> findALlCustomersByKey(String code, String name, String address, String phone, String groupId, Pageable pageable) {
        return iCustomerRepository.findALlCustomersByKey(code, name, address, phone, groupId, pageable);
    }

    @Override
    public List<CustomerGroup> findAllCustomerGroup() {
        return iCustomerGroupRepository.findAllCustomerGroup();
    }

}
