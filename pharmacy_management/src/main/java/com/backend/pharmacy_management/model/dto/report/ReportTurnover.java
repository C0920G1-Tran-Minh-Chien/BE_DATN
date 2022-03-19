package com.backend.pharmacy_management.model.dto.report;

public class ReportTurnover {
    private String doanhThu;
    private String tuNgay;
    private String denNgay;

    public ReportTurnover(String doanhThu, String tuNgay, String denNgay) {
        this.doanhThu = doanhThu;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
    }

    public String getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(String doanhThu) {
        this.doanhThu = doanhThu;
    }

    public String getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(String tuNgay) {
        this.tuNgay = tuNgay;
    }

    public String getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(String denNgay) {
        this.denNgay = denNgay;
    }
}
