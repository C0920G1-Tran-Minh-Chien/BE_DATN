package com.backend.pharmacy_management.model.dto.report;


public class ReportRefundExportDetails {
    private String maHoaDOn;
    private String ngayXuat;
    private String lyDo;
    private String soLuong;
    private String tongTien;

    public ReportRefundExportDetails(String maHoaDOn, String ngayXuat, String lyDo, String soLuong, String tongTien) {
        this.maHoaDOn = maHoaDOn;
        this.ngayXuat = ngayXuat;
        this.lyDo = lyDo;
        this.soLuong = soLuong;
        this.tongTien = tongTien;

    }

    public String getMaHoaDOn() {
        return maHoaDOn;
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

    public void setMaHoaDOn(String maHoaDOn) {
        this.maHoaDOn = maHoaDOn;
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

    public String getTongTien() {
        return tongTien;
    }
}
