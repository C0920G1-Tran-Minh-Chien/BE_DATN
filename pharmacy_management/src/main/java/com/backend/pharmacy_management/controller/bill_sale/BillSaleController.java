package com.backend.pharmacy_management.controller.bill_sale;
import com.backend.pharmacy_management.model.dto.BillSaleDto;
import com.backend.pharmacy_management.model.dto.DrugOfBillDto;
import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.backend.pharmacy_management.model.entity.user_role.User;
import com.backend.pharmacy_management.model.service.bill_sale.IBillSaleService;
import com.backend.pharmacy_management.model.service.bill_sale.IDrugOfBillService;
import com.backend.pharmacy_management.model.service.customer.ICustomerService;
import com.backend.pharmacy_management.model.service.drug.IDrugService;
import com.backend.pharmacy_management.model.service.employee.IEmployeeService;
import com.backend.pharmacy_management.model.service.prescription_indicative.IIndicativeService;
import com.backend.pharmacy_management.model.service.prescription_indicative.IPrescriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200/")
@RequestMapping(value = "bill-sale")
public class BillSaleController {
    @Autowired
    IDrugService iDrugService;
    @Autowired
    IBillSaleService iBillSaleService;
    @Autowired
    IDrugOfBillService iDrugOfBillService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IPrescriptionService iPrescriptionService;



    @GetMapping(value = "/get-list-drug")
    public ResponseEntity<List<Drug>> getListDrug() {
        List<Drug> drugList = iDrugService.findAllNormal();
        if (drugList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(drugList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/get-list-employee")
    public ResponseEntity<List<Employee>> getListEmployee() {
        List<Employee> employeeList = iEmployeeService.findAllNormal();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/get-list-customer")
    public ResponseEntity<List<Customer>> getListCustomer() {
        List<Customer> customerList = iCustomerService.findAllNormal();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/get-list-drug-of-bill")
    public ResponseEntity<List<DrugOfBill>> getListDrugOfBillByBillSaleId(@RequestParam String id) {
        List<DrugOfBill> drugOfBillList = iDrugOfBillService.findAllDrugOfBillByBillSaleId(id);
        if (drugOfBillList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(drugOfBillList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/find-drug-by-id")
    public ResponseEntity<Optional<Drug>> findDrugById(@RequestParam Long id) {
        Optional<Drug> drug = iDrugService.findById(id);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }

    @GetMapping(value = "get-bill-sale")
    public ResponseEntity<Optional<BillSale>> getBillSale(@RequestParam String id ){
        Optional<BillSale> billSale = Optional.ofNullable(iBillSaleService.findBillSaleByIdCode(id));
        return new ResponseEntity<>(billSale, HttpStatus.OK);
    }

    @PostMapping(value = "/create-bill-sale")
    public ResponseEntity<BillSale> createBillSale(@Valid @RequestBody BillSale billSaleDto) {
//        BillSale billSale = new BillSale();
//        BeanUtils.copyProperties(billSaleDto, billSale);

        this.iBillSaleService.save(billSaleDto);
        return new ResponseEntity<>(billSaleDto,HttpStatus.OK);
    }

    @PostMapping(value = "/create-drug-of-bill")
    public ResponseEntity<DrugOfBill> createDrugOfBill(@RequestBody DrugOfBillDto drugOfBillDto) {
        DrugOfBill drugOfBill = new DrugOfBill();
        BeanUtils.copyProperties(drugOfBillDto, drugOfBill);
        this.iDrugOfBillService.save(drugOfBill);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //TamNL
    @Autowired
    IIndicativeService iIndicativeService;

    @GetMapping("/prescription")
    public ResponseEntity<List<Prescription>> showPrescriptionList(){
        List<Prescription> list = (List<Prescription>) iPrescriptionService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/drug")
    public ResponseEntity<List<Drug>> showDrugList() {
        List<Drug> list = iDrugService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/drug-of-bill/{id}")
    public ResponseEntity<List<Indicative>> showDrugOfBillList(@PathVariable("id") Long id){
        List<Indicative> list = (List<Indicative>) this.iIndicativeService.findAllIndicative(id);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
    @GetMapping("/prescription/{id}")
    public ResponseEntity<Prescription> showPres(@PathVariable("id") Long id){
        Prescription prescription = iPrescriptionService.findById(id);
        if (prescription == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }
    @PostMapping("prescription/bill")
    public void save(@RequestBody BillSale billSale) {


        iBillSaleService.save(billSale);

    }

    @GetMapping("prescription/search")
    public ResponseEntity<List<Prescription>> searchPrescription(@RequestParam String fieldSearch, @RequestParam String valueSearch){


        List<Prescription> list = iPrescriptionService.search(fieldSearch, valueSearch);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("prescription/save")
    public void  saveDrugOfBIll(@RequestBody DrugOfBill drugOfBill) {
        iDrugOfBillService.save(drugOfBill);
    }

    @GetMapping("/prescription/find-bill")
    public ResponseEntity<BillSaleDto> findNewBill(){
        BillSaleDto bill = iBillSaleService.findBIll();
        return new  ResponseEntity<>(bill, HttpStatus.OK);
    }

   

}
