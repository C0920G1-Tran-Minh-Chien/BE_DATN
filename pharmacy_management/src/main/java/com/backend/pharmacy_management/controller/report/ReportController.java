package com.backend.pharmacy_management.controller.report;

import com.backend.pharmacy_management.model.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/report")
@CrossOrigin(origins = "http://localhost:4200/")
public class ReportController {
    @Autowired
    IReportService reportService;

    @GetMapping("/{choice}/{startDate}/{endDate}")
    public ResponseEntity<List> getList(@PathVariable String choice, @PathVariable String startDate, @PathVariable String endDate) {
        System.out.println(choice);
        switch (choice) {
            case "reportImportDetails":
                return new ResponseEntity<>(reportService.reportImportDetails(startDate, endDate), HttpStatus.OK);
            case "reportCancellationDetails":
                return new ResponseEntity<>(reportService.reportCancellationDetails(startDate, endDate), HttpStatus.OK);
            case "reportRefundExportDetails":
                return new ResponseEntity<>(reportService.reportRefundExportDetails(startDate, endDate), HttpStatus.OK);
            case "reportRetailDetails":
                return new ResponseEntity<>(reportService.reportRetailDetails(startDate, endDate), HttpStatus.OK);
            case "reportWholesaleDetails":
                return new ResponseEntity<>(reportService.reportWholesaleDetails(startDate, endDate), HttpStatus.OK);
            case "reportDetailsSoldByOrder":
                return new ResponseEntity<>(reportService.reportDetailsSoldByOrder(startDate, endDate), HttpStatus.OK);
            case "supplierList":
                return new ResponseEntity<>(reportService.supplierList(), HttpStatus.OK);
            case "reportOnMedicationBeingProvided":
                return new ResponseEntity<>(reportService.reportOnMedicationBeingProvided(), HttpStatus.OK);
            case "sellingDiarys":
                return new ResponseEntity<>(reportService.sellingDiarys(startDate, endDate), HttpStatus.OK);
            case "medicinesNeedToBeImporteds":
                return new ResponseEntity<>(reportService.medicinesNeedToBeImporteds(), HttpStatus.OK);
            case "theDrugIsAboutToExpires":
                return new ResponseEntity<>(reportService.theDrugIsAboutToExpires(), HttpStatus.OK);
            case "bestSellingDrugs":
                return new ResponseEntity<>(reportService.bestSellingDrugs(startDate, endDate), HttpStatus.OK);
            case "reportDebt":
                return new ResponseEntity<>(reportService.reportDebt(startDate, endDate), HttpStatus.OK);
            case "reportTurnover":
                return new ResponseEntity<>(reportService.reportTurnover(startDate, endDate), HttpStatus.OK);
            case "reportProfit":
                return new ResponseEntity<>(reportService.reportProfit(startDate, endDate), HttpStatus.OK);
            default:
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/chart/{startDate}/{endDate}")
    public ResponseEntity<List> getChart( @PathVariable String startDate, @PathVariable String endDate) {
        List a = reportService.getStatisticalChart(startDate, endDate);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}
