package com.backend.pharmacy_management.model.repository.drug_group;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDrugGroupRepository extends JpaRepository<DrugGroup,Long> {
}
