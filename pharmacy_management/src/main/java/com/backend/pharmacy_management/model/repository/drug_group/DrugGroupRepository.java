package com.backend.pharmacy_management.model.repository.drug_group;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DrugGroupRepository extends JpaRepository<DrugGroup,Long>  {

    @Query(value="select * from drug_group where flag=1",nativeQuery=true)
    Page<DrugGroup> findAllPage(Pageable pageable);

    @Query(value="select * from drug_group",nativeQuery=true)
    List<DrugGroup> findAll();

    @Query(value="select * from drug_group where flag=1",nativeQuery=true)
    List<DrugGroup> findAllCode();

    @Modifying
    @Transactional
    @Query(value="update drug_group set flag=0 where drug_group_id=?",nativeQuery=true)
    void delete(DrugGroup drugGroup);
}
