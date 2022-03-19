package com.backend.pharmacy_management.model.service.prescription_indicative.impl;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.backend.pharmacy_management.model.repository.prescription_indicative.IIndicativeRepository;
import com.backend.pharmacy_management.model.service.prescription_indicative.IIndicativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class IndicativeServiceImpl implements IIndicativeService {
    @Autowired
    private IIndicativeRepository iIndicativeRepository;
    @Override
    public Iterable<Indicative> findAll() {
        return this.iIndicativeRepository.findAll();
    }
    public Iterable<Indicative> findAllIndicative(Long id) {

        return this.iIndicativeRepository.findAllIndicative(id);
    }

    @Override
    public Indicative findById(Long id) {
        return this.findById(id);
    }

    @Override
    public Indicative save(Indicative indicative) {
        return this.iIndicativeRepository.save(indicative);
    }

    @Override
    public void remove(Long id) {
        this.iIndicativeRepository.deleteById(id);
    }
}
