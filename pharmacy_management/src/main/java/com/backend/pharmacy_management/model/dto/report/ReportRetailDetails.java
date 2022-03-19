package com.backend.pharmacy_management.model.dto.report;


public class ReportRetailDetails {
    private String maHoaDon;
    private String ngayBan;
    private String tongTien;

    public ReportRetailDetails(String maHoaDon, String ngayBan, String tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayBan = ngayBan;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public String getTongTien() {
        return tongTien;
    }
}
