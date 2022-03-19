package com.backend.pharmacy_management.model.dto.report;

public class ReportBestSellingDrug {
    private String maThuoc;
    private String nhomThuoc;
    private String tenThuoc;
    private String soLuongBan;

    public ReportBestSellingDrug() {
    }

    public ReportBestSellingDrug(String maThuoc, String nhomThuoc, String tenThuoc, String soLuongBan) {
        this.maThuoc = maThuoc;
        this.nhomThuoc = nhomThuoc;
        this.tenThuoc = tenThuoc;
        this.soLuongBan = soLuongBan;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getNhomThuoc() {
        return nhomThuoc;
    }

    public void setNhomThuoc(String nhomThuoc) {
        this.nhomThuoc = nhomThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(String soLuongBan) {
        this.soLuongBan = soLuongBan;
    }
}
