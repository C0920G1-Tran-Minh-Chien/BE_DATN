package com.backend.pharmacy_management.model.repository.prescription_indicative;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription,Long> {
    @Query(value="select *" +
            " from prescription" +
            " where prescription_name like %?1%" +
            " and prescription_code like %?2%" +
            " and object like %?3%" +
            " and  symptom like %?4%" +
            " and flag=0"
            ,nativeQuery = true)
    Page<Prescription> findByPrescriptionFilter(String prescriptionName, String prescriptionCode, String object , String symptom , Pageable pageable);

    @Query(value="select * from prescription where prescription_code=?",nativeQuery = true)
    Prescription getPrescriptionCode(String pres);

    @Query(value = "select * from prescription where prescription_id = ?;", nativeQuery = true)
    Prescription findPresById(Long id);
    @Query(value = "select * from prescription where prescription_name like ?", nativeQuery = true)
    List<Prescription> findpres(String valueSearch);

    @Query(value = "select * from prescription where symptom like ?", nativeQuery = true)
    List<Prescription> findBySign(String s);
}
