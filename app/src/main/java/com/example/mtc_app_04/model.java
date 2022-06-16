package com.example.mtc_app_04;

public class model {

    Long convDate;
    int statusReport;
    String eqName, inputTime, plant, probDesc, prodLine;


    public model() {
    }

    public model(Long convDate, int statusReport, String eqName, String inputTime, String plant, String probDesc, String prodLine) {
        this.convDate = convDate;
        this.statusReport = statusReport;
        this.eqName = eqName;
        this.inputTime = inputTime;
        this.plant = plant;
        this.probDesc = probDesc;
        this.prodLine = prodLine;
    }

    public Long getConvDate() {
        return convDate;
    }

    public void setConvDate(Long convDate) {
        this.convDate = convDate;
    }

    public int getStatusReport() {
        return statusReport;
    }

    public void setStatusReport(int statusReport) {
        this.statusReport = statusReport;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getProbDesc() {
        return probDesc;
    }

    public void setProbDesc(String probDesc) {
        this.probDesc = probDesc;
    }

    public String getProdLine() {
        return prodLine;
    }

    public void setProdLine(String prodLine) {
        this.prodLine = prodLine;
    }
}
