package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.DrugDTO;
import com.backend.pharmacy_management.model.dto.CreateDrugDto;
import com.backend.pharmacy_management.model.dto.DrugImageDetailDto;
import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;
import com.backend.pharmacy_management.model.repository.drug.IDrugRepository;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import com.backend.pharmacy_management.model.service.drug_group.IDrugGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("api/drugs")
public class DrugController {
    @Autowired
    private IDrugService drugService;
    @Autowired
    private IDrugGroupService drugGroupService;

    @Autowired
    private IDrugRepository drugRepository;
    @GetMapping
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsPagination(@RequestParam int index,
                                                                    @RequestParam(defaultValue = "") String nameDrug,
                                                                    @RequestParam(defaultValue = "") String drugGroup,
                                                                    @RequestParam(defaultValue = "") String activeElement
                                                                    ) {
        List<ListDrugDTO> drugs = drugRepository.findAllDrugsPagination(index, nameDrug, drugGroup, activeElement);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsSearch(@RequestParam String field, @RequestParam String sign, @RequestParam String input, @RequestParam String index) {
        if (!field.equals("") && sign.equals("like") && !input.equals("")) {
            input = '%' + input + '%';
        }

        List<ListDrugDTO> drugs = drugService.findAllDrugsSearch(field, sign, input, index);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }

    @GetMapping("/search-not-pagination")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsSearchNotPagination(@RequestParam String field, @RequestParam String sign, @RequestParam String input) {
        if (!field.equals("") && sign.equals("like") && !input.equals("")) {
            input = '%' + input + '%';
        }

        List<ListDrugDTO> drugs = drugService.findAllDrugsSearchNotPagination(field, sign, input);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    @GetMapping("/not-pagination")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsNotPagination(@RequestParam(defaultValue = "") String nameDrug,
                                                                       @RequestParam(defaultValue = "") String drugGroup,
                                                                       @RequestParam(defaultValue = "") String activeElement) {
        List<ListDrugDTO> drugs = drugService.findAllDrugsNotPagination(nameDrug, drugGroup, activeElement);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);

    }
    @GetMapping("/get-normal")
    public ResponseEntity<List<Drug>> findAllDrugsNormal() {
        List<Drug> drugs = drugService.findAllNormal();
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);

    }
    @GetMapping(value = "/drugGroup")
    public ResponseEntity<List<DrugGroup>> getListDrugGroup(){
        List<DrugGroup> listDrugGroup = drugGroupService.findAll();
        if (listDrugGroup.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listDrugGroup,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveDrug(@Valid @RequestBody CreateDrugDto createDrugDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.NOT_MODIFIED);
        }

        Drug drug = new Drug();
        BeanUtils.copyProperties(createDrugDto,drug);
        System.out.println(drug.getDrugFaculty());
        drug.setDrugCode((long) Math.floor(Math.random()*1000000));
        drugService.saveDrug(drug);
        DrugImageDetail drugImageDetail = new DrugImageDetail();
        drugImageDetail.setDrugImageDetailUrl(createDrugDto.getImg());
        drugImageDetail.setDrug(drug);
        drugService.saveDrugImage(drugImageDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping(value = "/image")
    public ResponseEntity<DrugImageDetail> saveDrugImage(@Valid @RequestBody DrugImageDetailDto drugImageDetailDto) {
        DrugImageDetail drugImageDetail = new DrugImageDetail();
        BeanUtils.copyProperties(drugImageDetailDto,drugImageDetail);
        return new ResponseEntity<>(drugService.saveDrugImage(drugImageDetail), HttpStatus.CREATED);
    }
    @PutMapping("/{id}&{code}")
    public ResponseEntity<?> updateDrug(@PathVariable Long id,@PathVariable Long code,@Valid @RequestBody CreateDrugDto createDrugDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.NOT_MODIFIED);
        }
      Optional<Drug> drug1 = drugService.findById(id);
        Drug drug = new Drug();
        BeanUtils.copyProperties(createDrugDto,drug);
        if (!drug1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        drug.setDrugId(drug1.get().getDrugId());
        drug.setDrugCode(code);
        return new ResponseEntity<>(drugService.saveDrug(drug), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DrugDTO> deleteById(@PathVariable Long id) {
        DrugDTO drug = drugService.findDrugById(id);
        if (drug == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        drugService.deleteDrugById(id);
        return new ResponseEntity<DrugDTO>(drug, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DrugDTO> findById(@PathVariable Long id) {
        DrugDTO drugDTO = drugService.findDrugById(id);
        if (drugDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DrugDTO>(drugDTO, HttpStatus.OK);
    }

    @GetMapping("/get-price-drug")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugsGetPrice() {
        List<ListDrugDTO> drugs = drugService.findAllDrugsGetPrice();
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);

    }

        @GetMapping("/list-drug-price/{id}")
    public ResponseEntity<List<ListDrugDTO>> findAllDrugOfListGetPrice(@PathVariable String id) {
        List<ListDrugDTO> drugs = drugService.findAllDrugsOfListGetPrice(id);
        if (drugs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);

    }

    @GetMapping("/drug-id-price/{id}")
    public ResponseEntity<ListDrugDTO> findDrugByIdGetPrice(@PathVariable String id) {
        ListDrugDTO drugs = drugService.findDrugByIdGetPrice(id);
        if (drugs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugs, HttpStatus.OK);

    }

    @GetMapping("/drugGroupId/{id}")
    public ResponseEntity<DrugGroup> findDrugGroupById(@PathVariable Long id) {
        DrugGroup drugGroup = drugGroupService.findById(id);
        if (drugGroup == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(drugGroup, HttpStatus.OK);
    }

}
  