package com.backend.pharmacy_management.model.dto.report;


public class ReportDetailsSoldByOrder {
    private String maHoaDon;
    private String ngayBan;
    private String tongTien;
    private String tenKhachHang;


    public ReportDetailsSoldByOrder(String maHoaDon, String ngayBan, String tongTien, String tenKhachHang) {
        this.maHoaDon = maHoaDon;
        this.ngayBan = ngayBan;
        this.tongTien = tongTien;
        this.tenKhachHang = tenKhachHang;
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

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public String getTongTien() {
        return tongTien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }
}
