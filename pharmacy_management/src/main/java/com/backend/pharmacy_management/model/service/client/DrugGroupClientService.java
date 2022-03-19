package com.backend.pharmacy_management.model.service.client;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.repository.drug.IDrugGroupClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugGroupClientService implements IDrugGroupClientService {
    @Autowired
    private IDrugGroupClientRepository iDrugGroupClientRepository;

    @Override
    public List<DrugGroup> findAll() {
        return (List<DrugGroup>) iDrugGroupClientRepository.findAll();
    }
}
