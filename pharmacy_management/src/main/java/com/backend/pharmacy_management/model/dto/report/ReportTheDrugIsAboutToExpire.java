package com.backend.pharmacy_management.model.dto.report;


public class ReportTheDrugIsAboutToExpire {
    private String maThuoc;
    private String tenThuoc;
    private String ngayHetHan;

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }
}
