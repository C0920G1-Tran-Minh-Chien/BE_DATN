package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;

public interface BillSaleDto {


    public Long getBillSaleId() ;

    public String getBillSaleCode() ;

    public String getInvoiceDate() ;

    public String getBillSaleNote() ;
    public String getBillSaleType() ;

    public Boolean getFlag() ;

    public Double getTotalMoney() ;



    public Employee getEmployee();



    public Customer getCustomer() ;


}
