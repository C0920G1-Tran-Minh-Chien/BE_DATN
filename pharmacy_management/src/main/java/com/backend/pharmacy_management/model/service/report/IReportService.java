package com.backend.pharmacy_management.model.service.report;

import com.backend.pharmacy_management.model.dto.report.*;

import java.util.List;

public interface IReportService {
    List<ReportImportDetails> reportImportDetails(String startDate, String endDate);
    List<ReportCancellationDetails> reportCancellationDetails(String startDate, String endDate);

    List<ReportRefundExportDetails> reportRefundExportDetails(String startDate, String endDate);

    List<ReportRetailDetails> reportRetailDetails(String startDate, String endDate);

    List<ReportWholesaleDetails> reportWholesaleDetails(String startDate, String endDate);
    List<ReportDetailsSoldByOrder> reportDetailsSoldByOrder(String startDate, String endDate);
    List<SupplierList> supplierList();
    List<ReportOnMedicationBeingProvided> reportOnMedicationBeingProvided();

    List<ReportSellingDiary> sellingDiarys(String startDate, String endDate);

    List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImporteds();

    List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires();

    List<ReportBestSellingDrug> bestSellingDrugs(String startDate, String endDate);

    List<ReportDebt> reportDebt(String startDate, String endDate);

    List<ReportTurnover> reportTurnover(String startDate, String endDate);

    List<ReportProfit> reportProfit(String startDate, String endDate);

    List<StatisticalChart> getStatisticalChart(String startDate, String endDate);
}
