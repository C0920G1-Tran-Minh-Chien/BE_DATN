package com.backend.pharmacy_management.model.service.export;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface ExportBillService {
    void createExportBill(ExportBill exportBill);
    void createExportBillDetail(ExportBillDetail exportBillDetail);
    String createExportBillRefundCode();
    String createExportBillDestroyCode();
    List<String> getAllExportBillCode();

    //List
    Page<ExportBill> findAll(Pageable pageable);
    ExportBill findById(long id);
    Page<ExportBill> findByFields(String field1, String field2, String field3, String field4, Long typeId, Pageable pageable) throws ParseException;
    void delete(long id);

}
