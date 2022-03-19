package com.backend.pharmacy_management.model.dto.report;

public class Turnover {
    private Double turnover;
    private String dateSale;

    public Turnover(Double turnover, String dateSale) {
        this.turnover = turnover;
        this.dateSale = dateSale;
    }

    public Turnover(double turnover) {
    }

    public String getDateSale() {
        return dateSale;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public void setDateSale(String dateSale) {
        this.dateSale = dateSale;
    }
}
