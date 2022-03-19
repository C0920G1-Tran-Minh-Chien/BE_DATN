package com.backend.pharmacy_management.model.dto.report;

public  class  StatisticalChart {
    private String turnover;
    private String profit;
    private String dateSale;

    public StatisticalChart(String turnover, String profit, String dateSale) {
        this.turnover = turnover;
        this.profit = profit;
        this.dateSale = dateSale;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getDateSale() {
        return dateSale;
    }

    public void setDateSale(String dateSale) {
        this.dateSale = dateSale;
    }
}
