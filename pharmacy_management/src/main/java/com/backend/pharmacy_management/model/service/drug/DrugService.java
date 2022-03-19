package com.backend.pharmacy_management.model.service.drug;
import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;
import com.backend.pharmacy_management.model.repository.drug.IDrugImageDetailRepository;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DrugService implements IDrugService {
    @Autowired
    private IDrugRepository iDrugRepository;
    @Autowired
    private IDrugImageDetailRepository iDrugImageDetailRepository;

    @Override
    public List<Drug> findAllNormal() {
        return iDrugRepository.findAll();
    }

    @Override
    public void save(Drug drug) {
        iDrugRepository.save(drug);
    }

    @Override
    public void remove(Long id) {

    }


    public List<ListDrugDTO> findAllDrugsPagination(int index) {
        return iDrugRepository.findAllDrugsPagination(index, "", "", "");

    }

    @Override
    public List<ListDrugDTO> findAllDrugsSearch(String field, String sign, String input, String index) {
        return iDrugRepository.findAllDrugsSearch(field, sign, input, index);
    }

    @Override
    public List<ListDrugDTO> findAllDrugsSearchNotPagination(String field, String sign, String input) {
        return iDrugRepository.findAllDrugsSearchNotPagination(field, sign, input);
    }



    @Override
    public List<ListDrugDTO> findAllDrugsNotPagination(String drugName, String drugGroup, String activeElement) {
        return iDrugRepository.findAllDrugsNotPagination(drugName, drugGroup, activeElement);
    }

//    @Override
//    public void saveDrug(Drug drug) {
//         iDrugRepository.createDrug(drug.getDrugCode(),drug.getDrugName(), drug.getActiveElement(),
//                drug.getUnit(), drug.getConversionUnit(), drug.getConversionRate(), drug.getWholesaleProfitRate(),
//                drug.getRetailProfitRate(), drug.getDrugFaculty(), drug.getManufacturer(), drug.getOrigin(),
//                drug.getNote(), drug.getFlag(), drug.getDrugSideEffect());
//    }


    public void deleteDrugById(Long id) {
        iDrugRepository.deleteDrugById(id);
    }

    @Override
    public DrugDTO findDrugById(Long id) {
        return iDrugRepository.findDrugById(id);
    }

    @Override
    public Page<Drug> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Drug> findById(Long id) {
        return iDrugRepository.findById(id);
    }

//    @Override
//    public void saveDrugImage(DrugImageDetail drugImageDetail) {
//        iDrugImageDetailRepository.createDrugImageDetail(drugImageDetail.getDrugImageDetailUrl());
//    }

    @Override
    public DrugImageDetail saveDrugImage(DrugImageDetail drugImageDetail) {
        return iDrugImageDetailRepository.save(drugImageDetail);
    }

    @Override
    public List<Drug> findAll() {
        return this.iDrugRepository.findAll();
    }

    @Override
    public Drug saveDrug(Drug drug) {
        return iDrugRepository.save(drug);
    }

    @Override
    public List<ListDrugDTO> findAllDrugsGetPrice(){
        return  this.iDrugRepository.findAllDrugsGetPrice();
    }

    @Override
    public List<ListDrugDTO> findAllDrugsOfListGetPrice(String id) {
        return this.iDrugRepository.findAllDrugsOfListGetPrice(id);
    }

    @Override
    public ListDrugDTO findDrugByIdGetPrice(String id) {
        return this.iDrugRepository.findDrugByIdGetPrice(id);
    }
}
