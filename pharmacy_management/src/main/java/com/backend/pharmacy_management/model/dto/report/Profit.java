package com.backend.pharmacy_management.model.dto.report;

public class Profit {
    private Double profit;
    private String dateSale;

    public Profit(Double profit, String dateSale) {
        this.profit = profit;
        this.dateSale = dateSale;
    }
    public String getDateSale() {
        return dateSale;
    }
    public Double getProfit() {
        return profit;
    }
    public void setProfit(Double profit) {
        this.profit = profit;
    }
    public void setDateSale(String dateSale) {
        this.dateSale = dateSale;
    }
}
