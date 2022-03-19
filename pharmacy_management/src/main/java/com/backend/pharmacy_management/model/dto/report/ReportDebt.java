package com.backend.pharmacy_management.model.dto.report;

public class ReportDebt {
    private String congNo;
    private String ngayNhap;

    public ReportDebt(String congNo, String ngayNhap) {
        this.congNo = congNo;
        this.ngayNhap = ngayNhap;
    }



    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getCongNo() {
        return congNo;
    }

    public void setCongNo(String congNo) {
        this.congNo = congNo;
    }
}
