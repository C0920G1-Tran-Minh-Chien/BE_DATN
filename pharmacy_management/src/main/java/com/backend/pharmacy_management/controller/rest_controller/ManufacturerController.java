package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.ManufacturerDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.service.manufacturer.IManufacturerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/manufacturer")
@CrossOrigin(value = "http://localhost:4200/")
public class ManufacturerController {
    @Autowired
    IManufacturerService iManufacturerService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Manufacturer>> listManufacturer(@RequestParam Optional<String> address, @RequestParam Optional<String> name, @RequestParam Optional<String> note,
                                                               @RequestParam Optional<String> code, @RequestParam Optional<String> phoneNumber, @RequestParam Optional<String> sort, @RequestParam Integer page) {
        String name1 = "";
        String note1 = "";
        String phoneNumber1 = "";
        String code1 = "";
        String address1 = "";
        String sort1 = "";

        if (address.isPresent()) {
            address1 = address.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerAddress(address1, PageRequest.of(page, 5));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (name.isPresent()) {
            name1 = name.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerName(name1, PageRequest.of(page, 5));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (code.isPresent()) {
            code1 = code.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerCode(code1, PageRequest.of(page, 5));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (note.isPresent()) {
            note1 = note.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerNote(note1, PageRequest.of(page, 5));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (phoneNumber.isPresent()) {
            phoneNumber1 = phoneNumber.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerPhoneNumber(phoneNumber1, PageRequest.of(page, 5));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (sort.isPresent()) {
            sort1 = sort.get();
            switch (sort1) {
                case "name": {

                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortName(PageRequest.of(page, 5));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                case "address": {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortAddress(PageRequest.of(page, 5));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                case "note": {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortNote(PageRequest.of(page, 5));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                case "code": {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortCode(PageRequest.of(page, 5));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                case "phoneNumber": {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortPhoneNumber(PageRequest.of(page, 5));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                default: {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllManufacturer(PageRequest.of(page, 5));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
            }
        } else {
            Page<Manufacturer> manufacturers = iManufacturerService.findAllManufacturer(PageRequest.of(page, 5));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<ObjectError>> createManufacturer(@Valid @RequestBody ManufacturerDto manufacturerDto, BindingResult bindingResult) {
        List<Manufacturer> manufacturers = iManufacturerService.getAll();
        for (int i = 0; i < manufacturers.size(); i++) {
            if (manufacturerDto.getManufacturerEmail().equals(manufacturers.get(i).getManufacturerEmail()) || manufacturerDto.getManufacturerCode().equals(manufacturers.get(i).getManufacturerCode())) {
                return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_FOUND);
            }
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);

        } else {
            Manufacturer manufacturer = new Manufacturer();
            BeanUtils.copyProperties(manufacturerDto, manufacturer);
            iManufacturerService.saveManufacturer(manufacturer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<List<ObjectError>> updateManufacturer(@RequestParam Long id, @Valid @RequestBody ManufacturerDto manufacturerDto, BindingResult bindingResult) {


        List<Manufacturer> manufacturers = iManufacturerService.getAll();
        for (int i = 0; i < manufacturers.size(); i++) {
            if (!id.equals(manufacturers.get(i).getManufacturerId()) && (manufacturerDto.getManufacturerEmail().equals(manufacturers.get(i).getManufacturerEmail()) || manufacturerDto.getManufacturerCode().equals(manufacturers.get(i).getManufacturerCode()))) {
                return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
            }

        }
        Manufacturer mf = iManufacturerService.findByManufacturerId(id);
        manufacturerDto.setManufacturerId(mf.getManufacturerId());

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        } else {
            Manufacturer manufacturer = new Manufacturer();
            BeanUtils.copyProperties(manufacturerDto, manufacturer);
            iManufacturerService.saveManufacturer(manufacturer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping(value = "/show")
    public ResponseEntity<Manufacturer> showManufacturer(@RequestParam Long id) {
        return new ResponseEntity<>(iManufacturerService.findByManufacturerId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/importBill/shows")
    public ResponseEntity<Page<ImportBill>> showImportBillIdManufacturer(@RequestParam Long id, @RequestParam Integer page, @RequestParam Optional<String> startDate, @RequestParam Optional<String> endDate) {
        String startDate1 = "";
        String endDate1 = "";

        if (startDate.isPresent() && endDate.isPresent()) {
            startDate1 = startDate.get();
            endDate1 = endDate.get();
            return new ResponseEntity<>(iManufacturerService.findByDateImportBill(id, startDate1, endDate1, PageRequest.of(page, 5)), HttpStatus.OK);
        }
        return new ResponseEntity<>(iManufacturerService.findByIdManufacturer(id, PageRequest.of(page, 2)), HttpStatus.OK);
    }

    @GetMapping(value = "/importBill")
    public ResponseEntity<ImportBill> findByIdImportBill(@RequestParam Long id) {
        return new ResponseEntity<>(iManufacturerService.findByIdImportBill(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Manufacturer>> getAll() {
        return new ResponseEntity<>(iManufacturerService.getAll(), HttpStatus.OK
        );
    }

    @PutMapping(value = "/delete")
    public ResponseEntity<List<ObjectError>> deleteManufacturer(@RequestParam Long id, @Valid @RequestBody ManufacturerDto manufacturerDto, BindingResult bindingResult) {

        Manufacturer mf = iManufacturerService.findByManufacturerId(id);
        manufacturerDto.setManufacturerId(mf.getManufacturerId());
        if (bindingResult.hasErrors() || mf.getFlag()==0) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        } else {
            Manufacturer manufacturer = new Manufacturer();
            BeanUtils.copyProperties(manufacturerDto, manufacturer);
            iManufacturerService.saveManufacturer(manufacturer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
