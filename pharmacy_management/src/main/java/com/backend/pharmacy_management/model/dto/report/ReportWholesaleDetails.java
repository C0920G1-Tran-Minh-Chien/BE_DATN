package com.backend.pharmacy_management.model.dto.report;


public class ReportWholesaleDetails {
    private String maHoaDon;
    private String ngayBan;
    private String tongTien;
    private String tenKhachHang;

    public ReportWholesaleDetails(String maHoaDon, String ngayBan, String tongTien, String tenKhachHang) {
        this.maHoaDon = maHoaDon;
        this.ngayBan = ngayBan;
        this.tongTien = tongTien;
        this.tenKhachHang = tenKhachHang;

    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }
}
