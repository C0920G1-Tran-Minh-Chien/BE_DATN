package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.dto.DrugCartDTO;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.service.client.IDrugClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/drug-client/")
public class DrugClientController {
    @Autowired
    private IDrugClientService drugService;

    @GetMapping
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsPagination(@RequestParam int index) {
        List<ListDrugDTO> drugs = drugService.findAllDrugsPagination(index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsNotPagination() {
        List<ListDrugDTO> drugs = drugService.findAllDrugsNotPagination();
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @GetMapping(value={"/search-drug/{searchTerm}"})
    public ResponseEntity<List<ListDrugDTO>> searchDrug(@PathVariable String searchTerm) {
        List<ListDrugDTO> drugs = drugService.searchDrugs(searchTerm);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @GetMapping(value={"/drug-group/{drugGroupName}"})
    public ResponseEntity<List<ListDrugDTO>> findDrugByGroup(@PathVariable String drugGroupName) {
        List<ListDrugDTO> drugs = drugService.findDrugByGroup(drugGroupName);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrugDTO> findById(@PathVariable Long id) {
        DrugDTO drugDTO = drugService.findDrugById(id);
        if (drugDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(drugDTO, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<DrugDTO> findByIdClient(@PathVariable Long id) {
        DrugDTO drugDTO = drugService.findDrugByIdClient(id);
        if (drugDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(drugDTO, HttpStatus.OK);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<DrugCartDTO> findCartDrugById(@PathVariable Long id) {
        DrugCartDTO drugCartDTO = drugService.findDrugCartById(id);
        if (drugCartDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(drugCartDTO, HttpStatus.OK);
    }
}
  