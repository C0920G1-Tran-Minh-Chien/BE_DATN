package com.backend.pharmacy_management.controller.prescription_indicative;

import com.backend.pharmacy_management.model.dto.PrescriptionDto;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.backend.pharmacy_management.model.service.prescription_indicative.IPrescriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "prescriptions")
@CrossOrigin(origins = "http://localhost:4200/")
public class PrescriptionController {
    @Autowired
    private IPrescriptionService iPrescriptionService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Prescription>> getList() {
        List<Prescription> prescriptionList = (List<Prescription>) this.iPrescriptionService.findAll();
        if (prescriptionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prescriptionList, HttpStatus.OK);
    }

    @GetMapping(value = "/prescription-list")
    public ResponseEntity<Page<Prescription>> showList(@RequestParam Optional<String> prescriptionName,
                                                       @RequestParam Optional<String> prescriptionCode,
                                                       @RequestParam Optional<String> object,
                                                       @RequestParam Optional<String> symptom,
                                                       @RequestParam Optional<Integer> page,
                                                       @RequestParam Optional<String> sortBy) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse("prescription_id"));

        Page<Prescription> prescriptionList = iPrescriptionService.searchPrescription(prescriptionName.orElse(""), prescriptionCode.orElse(""), object.orElse(""), symptom.orElse(""), pageable);
        if (prescriptionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prescriptionList, HttpStatus.OK);
    }

    @GetMapping("/prescriptions/{id}")
    public ResponseEntity<Prescription> findPrescriptionById(@PathVariable Long id) {
        Prescription prescription = iPrescriptionService.findById(id);
        if (prescription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }

    @PostMapping(value = "/prescription-create")
    public ResponseEntity<Prescription> savePrescription(@Valid @RequestBody PrescriptionDto prescriptionDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else {
            Prescription prescription = new Prescription();
            BeanUtils.copyProperties(prescriptionDto, prescription);
            return new ResponseEntity<>(iPrescriptionService.save(prescription), HttpStatus.CREATED);
        }
    }

    @PutMapping("/prescription-edit/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @Valid @RequestBody PrescriptionDto prescriptionDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            Prescription prescription1 = iPrescriptionService.findById(id);
            Prescription prescription = new Prescription();
            prescriptionDto.setPrescriptionId(prescription1.getPrescriptionId());
            BeanUtils.copyProperties(prescriptionDto, prescription);
            return new ResponseEntity<>(iPrescriptionService.save(prescription), HttpStatus.OK);
        }

    }


    @DeleteMapping("/prescription-delete/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable Long id) {
        Prescription prescription = iPrescriptionService.findById(id);
        if (prescription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        prescription.setFlag(true);
        iPrescriptionService.save(prescription);
        return new ResponseEntity<>(prescription, HttpStatus.NO_CONTENT);
    }
}
