package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.ImportBillDrugDto;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import com.backend.pharmacy_management.model.service.import_bill.IImportBillDrugService;
import com.backend.pharmacy_management.model.service.import_bill.IImportBillService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/importBillDrugs")
public class ImportBillDrugRestController {
    private final IImportBillDrugService importBillDrugService;
    private final IImportBillService importBillService;
    private final IDrugService drugService;

    public ImportBillDrugRestController(IImportBillDrugService importBillDrugService, IImportBillService importBillService, IDrugService drugService) {
        this.importBillDrugService = importBillDrugService;
        this.importBillService = importBillService;
        this.drugService = drugService;
    }
    @GetMapping
    public ResponseEntity<List<ImportBillDrug>> getAll() {
        List<ImportBillDrug> importBillDrugs = importBillDrugService.findAllNormal();
        if (importBillDrugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBillDrugs, HttpStatus.OK);
    }

    @PostMapping(value= "", consumes={"application/json"})
    public ResponseEntity<ImportBillDrug> create(@Valid @RequestBody ImportBillDrugDto importBillDrugDto) {
        Optional<ImportBill> importBill = importBillService.findById(importBillDrugDto.getImportBill().getImportBillId());
        Optional<Drug> drug = drugService.findById(importBillDrugDto.getDrug().getDrugId());
        if(drug.isPresent() && importBill.isPresent()){
            ImportBillDrug importBillDrug = new ImportBillDrug();
            BeanUtils.copyProperties(importBillDrugDto, importBillDrug);
            this.importBillDrugService.save(importBillDrug);
            return new ResponseEntity<>(importBillDrug,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImportBillDrug> getImportBillDrugs(@PathVariable Long id) {
        Optional<ImportBillDrug> importBillDrug = importBillDrugService.findById(id);
        return importBillDrug.map(billDrug -> new ResponseEntity<>(billDrug, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ImportBillDrug> update(@Valid @RequestBody ImportBillDrugDto importBillDrugDto, @PathVariable Long id) {
        ImportBillDrug importBillDrug = new ImportBillDrug();
        BeanUtils.copyProperties(importBillDrugDto, importBillDrug);
        this.importBillDrugService.save(importBillDrug);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
