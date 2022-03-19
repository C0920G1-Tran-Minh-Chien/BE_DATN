package com.backend.pharmacy_management.model.dto.report;


public class SupplierList {
    private String tenNhaCungCap;
    private String diaChi;
    private String soDienThoai;
    private String ghiChu;
    public SupplierList(String tenNhaCungCap, String diaChi, String soDienThoai, String ghiChu) {
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ghiChu = ghiChu;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }
}
