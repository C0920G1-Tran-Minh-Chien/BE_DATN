package com.backend.pharmacy_management.model.repository.customer;

import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerGroupRepository extends JpaRepository<CustomerGroup, Long> {
    @Query (value = "select * from customer_group", nativeQuery = true)
    List<CustomerGroup> findAllCustomerGroup();
}
