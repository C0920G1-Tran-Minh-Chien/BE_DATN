package com.backend.pharmacy_management.model.service.drug_group.impl;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.repository.drug_group.DrugGroupRepository;
import com.backend.pharmacy_management.model.service.drug_group.IDrugGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DrugGroupService implements IDrugGroupService {
    @Autowired
    DrugGroupRepository drugGroupRepository;

    @Override
    public List<DrugGroup> findAll() {
        return drugGroupRepository.findAll();
    }

    @Override
    public DrugGroup findById(Long drugGroupId) {
        return drugGroupRepository.findById(drugGroupId).orElse(null);
    }

    @Override
    public DrugGroup save(DrugGroup drugGroup) {
        return drugGroupRepository.save(drugGroup);
    }

    @Override
    public void delete(DrugGroup drugGroup) {
        drugGroupRepository.delete(drugGroup);
    }

    @Override
    public Page<DrugGroup> findAllPage(Pageable pageable) {
        return drugGroupRepository.findAllPage(pageable);
    }

    @Override
    public List<DrugGroup> findAllCode() {
        return drugGroupRepository.findAllCode();
    }
}
