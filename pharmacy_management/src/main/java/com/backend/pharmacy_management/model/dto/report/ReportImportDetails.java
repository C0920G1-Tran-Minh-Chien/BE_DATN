package com.backend.pharmacy_management.model.dto.report;


public class ReportImportDetails {
    private String maHoaDon;
    private String tenNhaCungCap;
    private String ngayNhap;
    private String tongTien;
    private String ghiChu;

    public ReportImportDetails(String maHoaDon, String tenNhaCungCap, String ngayNhap, String tongTien, String ghiChu) {
        this.maHoaDon = maHoaDon;
        this.tenNhaCungCap = tenNhaCungCap;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public String getTongTien() {
        return tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }
}
