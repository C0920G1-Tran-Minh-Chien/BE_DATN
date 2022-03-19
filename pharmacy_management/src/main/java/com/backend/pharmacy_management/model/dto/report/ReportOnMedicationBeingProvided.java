package com.backend.pharmacy_management.model.dto.report;


public class ReportOnMedicationBeingProvided {
    private String tenThuoc;
    private String hoatChat;
    private String tacDungPhu;
    private String nguonGoc;
    private String nhaCungCap;

    public ReportOnMedicationBeingProvided(String tenThuoc, String hoatChat, String tacDungPhu, String nguonGoc, String nhaCungCap) {
        this.tenThuoc = tenThuoc;
        this.hoatChat = hoatChat;
        this.tacDungPhu = tacDungPhu;
        this.nguonGoc = nguonGoc;
        this.nhaCungCap = nhaCungCap;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getHoatChat() {
        return hoatChat;
    }

    public void setHoatChat(String hoatChat) {
        this.hoatChat = hoatChat;
    }

    public String getTacDungPhu() {
        return tacDungPhu;
    }

    public void setTacDungPhu(String tacDungPhu) {
        this.tacDungPhu = tacDungPhu;
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}
