package com.backend.pharmacy_management.model.repository.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IDrugImageDetailRepository extends JpaRepository<DrugImageDetail, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into drug_image_detail (drug_image_detail_url) " +
            "values (?1)",nativeQuery = true)
    void createDrugImageDetail(String drugImageDetailUrl);
}
