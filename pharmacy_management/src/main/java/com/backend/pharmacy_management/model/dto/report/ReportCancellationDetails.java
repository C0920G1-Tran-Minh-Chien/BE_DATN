package com.backend.pharmacy_management.model.dto.report;

public class ReportCancellationDetails {
    private String maHoaDon;
    private String ngayXuat;
    private String lyDo;
    private String soLuong;
    private String tongTien;

    public ReportCancellationDetails(String maHoaDon, String ngayXuat, String lyDo, String soLuong, String tongTien) {
        this.maHoaDon = maHoaDon;
        this.ngayXuat = ngayXuat;
        this.lyDo = lyDo;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public String getLyDo() {
        return lyDo;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public String getTongTien() {
        return tongTien;
    }
}
