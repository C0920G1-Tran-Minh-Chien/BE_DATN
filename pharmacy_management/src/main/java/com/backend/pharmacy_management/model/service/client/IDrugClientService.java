package com.backend.pharmacy_management.model.service.client;

import com.backend.pharmacy_management.model.dto.DrugCartDTO;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.dto.ListDrugDTO;

import java.util.List;

public interface IDrugClientService {
    List<ListDrugDTO> findAllDrugsPagination(int index);
    List<ListDrugDTO> findAllDrugsNotPagination();
    List<ListDrugDTO> searchDrugs(String searchTerm);
    List<ListDrugDTO> findDrugByGroup(String drugGroupName);
    DrugDTO findDrugById(Long id);
    DrugDTO findDrugByIdClient(Long id);
    DrugCartDTO findDrugCartById(Long id);
}
