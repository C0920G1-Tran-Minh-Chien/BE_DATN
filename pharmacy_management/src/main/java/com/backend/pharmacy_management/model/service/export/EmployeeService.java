package com.backend.pharmacy_management.model.service.export;

import com.backend.pharmacy_management.model.entity.employee.Employee;

public interface EmployeeService {
    Employee findById(Long id);
}
