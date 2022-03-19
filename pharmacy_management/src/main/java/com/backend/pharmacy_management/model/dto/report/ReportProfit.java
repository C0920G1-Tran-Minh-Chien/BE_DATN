package com.backend.pharmacy_management.model.dto.report;

public class ReportProfit {
    private String loiNhuan;
    private String tuNgay;
    private String denNgay;

    public ReportProfit(String loiNhuan, String tuNgay, String denNgay) {
        this.loiNhuan = loiNhuan;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
    }

    public String getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(String loiNhuan) {
        this.loiNhuan = loiNhuan;
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
