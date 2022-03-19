package com.backend.pharmacy_management.model.service.drug_group;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IDrugGroupService {

    List<DrugGroup> findAll();

    DrugGroup findById(Long drugGroupId);

    DrugGroup save(DrugGroup drugGroup);

    void delete(DrugGroup drugGroup);

    Page<DrugGroup> findAllPage(Pageable pageable);
    List<DrugGroup> findAllCode();
}
