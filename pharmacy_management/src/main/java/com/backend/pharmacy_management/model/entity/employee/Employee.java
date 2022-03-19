package com.backend.pharmacy_management.model.entity.employee;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.entity.user_role.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeAddress;
    private String employeeImage;
    private String employeePhone;
    private String employeeStartDate;
    private String employeeNote;
    private String position;
    private String accountName;

    public Employee(Long employeeId) {
        this.employeeId = employeeId;
    }

    @OneToMany(mappedBy = "employee")
    @JsonBackReference(value = "employee-import_bill")
    List<ImportBill> importBills;
    @OneToMany(mappedBy = "employee")
    @JsonBackReference(value = "employee-export_bill")
    List<ExportBill> exportBills;
    @OneToMany(mappedBy = "employee")
    @JsonBackReference(value = "employee-bill_sale")
    List<BillSale> billWholesales;
    @OneToOne(mappedBy = "employee" )
    @JsonIgnore
    private User user;

}
