package com.backend.pharmacy_management.model.service.employee;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee>searchEmployee(String keyWord, Pageable pageable);

    Page<Employee> searchEmployee(String employeeName, String employeeAddress , String employeeCode, String employeePhone,String position , Pageable pageable);
    void deleteEmployee(long id);
    Employee findById(long id);
    Employee saves(Employee employee);
    Employee findEmployee(Long id);
    Employee updateEmployee(Employee employee);
}
