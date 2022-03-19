package com.backend.pharmacy_management.model.dto.report;

public class ReportMedicinesNeedToBeImported {
    private String maThuoc;
    private String tenThuoc;
    private String soLuong;

    public ReportMedicinesNeedToBeImported() {
    }

    public ReportMedicinesNeedToBeImported(String maThuoc, String tenThuoc, String soLuong) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.soLuong = soLuong;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }
    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }
}
