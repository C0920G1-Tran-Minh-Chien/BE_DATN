package com.backend.pharmacy_management.model.service.export;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import com.backend.pharmacy_management.model.repository.export.ExportBillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExportBillTypeImpl implements ExportBillTypeService {
    @Autowired
    private ExportBillTypeRepository exportBillTypeRepository;
    @Override
    public List<ExportBillType> findAllExportBillType() {
        return exportBillTypeRepository.findAll();
    }
}
