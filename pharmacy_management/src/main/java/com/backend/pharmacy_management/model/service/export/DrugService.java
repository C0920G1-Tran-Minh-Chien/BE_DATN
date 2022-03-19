package com.backend.pharmacy_management.model.service.export;

import com.backend.pharmacy_management.model.entity.drug.Drug;

import java.util.List;

public interface DrugService {
    List<Drug> findAllDrug();
    void updateAmountDrug(Long id, Integer amount);
    Drug findById(Long id);
}
