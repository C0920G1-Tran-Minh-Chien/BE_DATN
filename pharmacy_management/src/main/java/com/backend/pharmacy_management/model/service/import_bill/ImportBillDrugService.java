
package com.backend.pharmacy_management.model.service.import_bill;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.repository.import_bill.IImportBillDrugRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ImportBillDrugService implements IImportBillDrugService{
    private final IImportBillDrugRepository iImportBillDrugRepository;

    public ImportBillDrugService(IImportBillDrugRepository iImportBillDrugRepository) {
        this.iImportBillDrugRepository = iImportBillDrugRepository;
    }

    @Override
    public Page<ImportBillDrug> findAllWithKeyWord(Pageable pageable, String keyword) {
        return iImportBillDrugRepository.findAll(pageable);
    }

    @Override
    public Optional<ImportBillDrug> findById(Long id) {
        return iImportBillDrugRepository.findById(id);
    }

    @Override
    public List<ImportBillDrug> findAllNormal() {
        return iImportBillDrugRepository.findAll();
    }

    @Override
    public void save(ImportBillDrug importBillDrug) {
        iImportBillDrugRepository.save(importBillDrug);
    }

    @Override
    public void remove(Long id) {
        iImportBillDrugRepository.deleteById(id);
    }
    @Override
    public List<ImportBillDrug> findAllImportBill() {
        return this.iImportBillDrugRepository.getAll();
    }

    @Override
    public ImportBillDrug findDrugByid(Long id) {
        return this.iImportBillDrugRepository.findById(id).orElse(null);
    }

    @Override
    public List<ImportBillDrug> getAllImportBillDrugByManufacuterId(Long id) {
        return this.iImportBillDrugRepository.getAllImportBillDrugByManufacuterId(id);
    }

    @Override
    public void updateImportBillDrug(Long id) {
        ImportBillDrug importBillDrug = this.findDrugByid(id);
        importBillDrug.setFlag(false);
        this.iImportBillDrugRepository.save(importBillDrug);
    }

}