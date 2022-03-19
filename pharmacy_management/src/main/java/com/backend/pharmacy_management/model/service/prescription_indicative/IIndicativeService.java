package com.backend.pharmacy_management.model.service.prescription_indicative;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;

public interface  IIndicativeService extends  IGeneralService<Indicative> {
    Iterable<Indicative> findAllIndicative(Long id);
}
