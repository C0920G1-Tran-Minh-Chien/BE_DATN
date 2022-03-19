package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.EmployeeDto;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>>findEmployeeByRequest(@RequestParam Optional<String> employeeName, @RequestParam Optional<String> employeeAddress, @RequestParam Optional<String> employeeCode, @RequestParam Optional<String> employeePhone,
                                                       @RequestParam Optional<String> position,
                                                       @RequestParam Optional<Integer> page,@RequestParam Optional<String> sortBy){
        Pageable pageable=PageRequest.of(page.orElse(0),5,Sort.Direction.ASC,sortBy.orElse("employee_id"));
        Page<Employee> employeePage = employeeService.searchEmployee(employeeName.orElse(""),employeeAddress.orElse(""),employeeCode.orElse(""),employeePhone.orElse(""),position.orElse(""),pageable);
        if (employeePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }
    @DeleteMapping("/employee/delete")
    public ResponseEntity<Employee>deleteEmployee(@RequestParam long id){
        Employee  employee= employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
    }

    @PostMapping("employee/create")
    public ResponseEntity<Employee> save(@Valid @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        Employee employee = new Employee();
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(employeeDto,employee);
        return new ResponseEntity<>(employeeService.saves(employee),HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeDto employeeDto , BindingResult bindingResult) {
        Employee employee = employeeService.findEmployee(id);
        if (employee==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee1 = new Employee();
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeDto.setEmployeeId(employee.getEmployeeId());
        BeanUtils.copyProperties(employeeDto,employee1);

        return new ResponseEntity<>(employeeService.updateEmployee(employee1), HttpStatus.OK);

    }


    }
