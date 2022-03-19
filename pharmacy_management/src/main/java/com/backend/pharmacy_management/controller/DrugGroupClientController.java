package com.backend.pharmacy_management.controller;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.service.client.IDrugGroupClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/drug-group")
public class DrugGroupClientController {
    @Autowired
    private IDrugGroupClientService drugGroupService;

    @GetMapping
    public ResponseEntity<List<DrugGroup>> getAllDrugGroups() {
        List<DrugGroup> drugGroupsList = this.drugGroupService.findAll();

        if (drugGroupsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(drugGroupsList,HttpStatus.OK);
    }
}
