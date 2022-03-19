package com.backend.pharmacy_management.model.repository.export;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExportBillDetailRepository extends JpaRepository<ExportBillDetail,Long> {
}
