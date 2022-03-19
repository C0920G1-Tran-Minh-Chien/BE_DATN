package com.backend.pharmacy_management.model.service.client;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;

import java.util.List;

public interface IDrugGroupClientService {
    List<DrugGroup> findAll();
}
