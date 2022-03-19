package com.backend.pharmacy_management.model.dto;

public interface  ListImportDto {

    int getBillId();

    String getSystemCode();

    String getAccountingVoucher();

    String getInvoiceDate();

    String getTotalMoney();

    String getOwnBill();

    String getManufacturerName();

    String getManufacturerAddress();
}
