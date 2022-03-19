package com.backend.pharmacy_management.model.service.prescription_indicative;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPrescriptionService extends IGeneralService<Prescription> {
    Page<Prescription> getAllPrescriptionList(Pageable pageable);

        Page<Prescription> searchPrescription(String name, String code, String object , String symptom , Pageable pageable);
    Prescription getPrescriptionCode(String pres);

    List<Prescription> search(String fieldSearch, String valueSearch);
}
