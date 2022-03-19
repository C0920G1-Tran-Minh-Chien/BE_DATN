package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.ImportBillDto;
import com.backend.pharmacy_management.model.dto.ListImportDto;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.Payment;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.repository.import_bill.IListImportDtoRepository;
import com.backend.pharmacy_management.model.service.employee.IEmployeeService;
import com.backend.pharmacy_management.model.service.import_bill.IImportBillService;
import com.backend.pharmacy_management.model.service.import_bill.IPaymentService;
import com.backend.pharmacy_management.model.service.manufacturer.IManufacturerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/import-bills")
public class ImportBillRestController {
    private final IImportBillService importBillService;
    private final IPaymentService paymentService;
    private final IEmployeeService employeeService;
    private final IManufacturerService manufacturerService;
    @Autowired
    private IListImportDtoRepository iListImportDtoRepository;


    @Autowired
    public ImportBillRestController(IImportBillService importBillService, IPaymentService paymentService, IEmployeeService employeeService, IManufacturerService manufacturerService) {
        this.importBillService = importBillService;
        this.paymentService = paymentService;
        this.employeeService = employeeService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public ResponseEntity<List<ImportBill>> getAll() {
        List<ImportBill> importBills = importBillService.findAllNormal();
        if (importBills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBills, HttpStatus.OK);
    }

    @PostMapping(value= "", consumes={"application/json"})
    public ResponseEntity<ImportBill> create(@Valid @RequestBody ImportBillDto importBillDto) {
        Optional<Employee> employee = employeeService.findById(importBillDto.getEmployee().getEmployeeId());
        Optional<Manufacturer> manufacturer = manufacturerService.findByIdM(importBillDto.getManufacturer().getManufacturerId());
        Optional<Payment> payment = paymentService.findById(importBillDto.getPayment().getPaymentId());
        if (payment.isPresent() && manufacturer.isPresent() && employee.isPresent()) {
            ImportBill importBill = new ImportBill();
            BeanUtils.copyProperties(importBillDto, importBill);
            this.importBillService.save(importBill);
            return new ResponseEntity<>(importBill,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImportBill> getImportBills(@PathVariable Long id) {
        Optional<ImportBill> importBill = importBillService.findById(id);

        return  importBill.map(importBillValue -> new ResponseEntity<>(importBillValue, HttpStatus.OK)).orElseGet(() ->  new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ImportBill> update(@Valid @RequestBody ImportBillDto importBillDto, @PathVariable Long id) {
        ImportBill importBill = new ImportBill();
        BeanUtils.copyProperties(importBillDto, importBill);
        importBill.setImportBillId(id);
        this.importBillService.save(importBill);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ImportBill> deleteBill(@PathVariable Long id) {
        Optional<ImportBill> importBillOptional = importBillService.findById(id);
        if (!importBillOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        importBillService.deleteImportBill(id);
        return new ResponseEntity<>(importBillOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/list-bills")
    public ResponseEntity<List<ListImportDto>> getListImportDto(@RequestParam int index) {
        List<ListImportDto> importBills = importBillService.getListImportDto(index);
        if (importBills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBills, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ImportBill>> getListBill(@RequestParam Integer page) {
        Page<ImportBill> listPatient = importBillService.getPageListImportDto(PageRequest.of(page, 5));
        return new ResponseEntity<>(listPatient, HttpStatus.OK);
    }

    @GetMapping("/search-sort-page")
    public ResponseEntity<Page<ListImportDto>> searchAndSortBill(@RequestParam(defaultValue = "") String codeBill,
                                                                 @RequestParam(defaultValue = "") String startDate,
                                                                 @RequestParam(defaultValue = "") String endDate,
//                                                                 @RequestParam(defaultValue = "") String sort,
                                                                 @RequestParam int page) {
        Page<ListImportDto> importBillDtoPage = importBillService.searchAndSortPaging(codeBill, startDate, endDate, page);
        if (importBillDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBillDtoPage, HttpStatus.OK);
    }

    @GetMapping("/list-bill-page")
    public ResponseEntity<Page<ListImportDto>> searchListPage(@RequestParam int page) {
        Page<ListImportDto> importBillDtoPage = importBillService.getAllBill(page);
        if (importBillDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBillDtoPage, HttpStatus.OK);
    }

    @GetMapping("/search-sort-page-bill")
    public ResponseEntity<Page<ListImportDto>> searchAndSortPagingBill(@RequestParam(defaultValue = "") String codeBill,
                                                                       @RequestParam(defaultValue = "") String startDate,
                                                                       @RequestParam(defaultValue = "") String endDate,
                                                                       @RequestParam(defaultValue = "") String sort,
                                                                       @RequestParam int page) {
        Page<ListImportDto> importBillDtoPage ;
        if (sort.equals("")){
             importBillDtoPage = importBillService.searchAndPaging(codeBill, startDate, endDate, page);

        } else {
            importBillDtoPage = importBillService.searchAndPaging2(codeBill, startDate, endDate, page);

        }
        if (importBillDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(importBillDtoPage, HttpStatus.OK);
    }
}
