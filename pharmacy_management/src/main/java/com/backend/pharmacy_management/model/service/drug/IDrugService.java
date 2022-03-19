package com.backend.pharmacy_management.model.service.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;
import com.backend.pharmacy_management.model.service.IGeneralService;

import java.util.List;

public interface IDrugService extends IGeneralService<Drug> {
    Drug saveDrug(Drug drug);
//    void saveDrug(Drug drug);
    List<ListDrugDTO> findAllDrugsPagination(int index);
    List<ListDrugDTO> findAllDrugsSearch(String field, String sign, String input, String index);
    List<ListDrugDTO> findAllDrugsSearchNotPagination(String field, String sign, String input);
    List<ListDrugDTO> findAllDrugsNotPagination(String drugName, String drugGroup, String activeElement);
    void deleteDrugById(Long id);
    DrugDTO findDrugById(Long id);
//    void saveDrugImage(DrugImageDetail drugImageDetail);
    DrugImageDetail saveDrugImage(DrugImageDetail drugImageDetail);

    List<Drug> findAll();
    public List<ListDrugDTO> findAllDrugsGetPrice();
    List<ListDrugDTO> findAllDrugsOfListGetPrice(String id);
    ListDrugDTO findDrugByIdGetPrice(String id);
}
