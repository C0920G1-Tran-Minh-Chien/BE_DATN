package com.backend.pharmacy_management.model.repository.export;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExportBillTypeRepository extends JpaRepository<ExportBillType,Long> {
}
