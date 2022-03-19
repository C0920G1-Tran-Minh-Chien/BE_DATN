package com.backend.pharmacy_management.model.service.client;

import com.backend.pharmacy_management.model.dto.DrugCartDTO;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.repository.drug.IDrugClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugClientService implements IDrugClientService {
    @Autowired
    private IDrugClientRepository iDrugClientRepository;

    @Override
    public List<ListDrugDTO> findAllDrugsPagination(int index) {
        return iDrugClientRepository.findAllDrugsPagination(index);
    }

    @Override
    public List<ListDrugDTO> findAllDrugsNotPagination() {
        return iDrugClientRepository.findAllDrugsNotPagination();
    }

    @Override
    public List<ListDrugDTO> searchDrugs(String searchTerm) {
        return iDrugClientRepository.searchDrugs(searchTerm);
    }

    @Override
    public List<ListDrugDTO> findDrugByGroup(String drugGroupName) {
        return iDrugClientRepository.findDrugByGroup(drugGroupName);
    }

    @Override
    public DrugDTO findDrugById(Long id) {
        return iDrugClientRepository.findDrugById(id);
    }

    @Override
    public DrugDTO findDrugByIdClient(Long id) {
        return iDrugClientRepository.findDrugByIdClient(id);
    }

    @Override
    public DrugCartDTO findDrugCartById(Long id) {
        return iDrugClientRepository.findDrugCartById(id);
    }
}
