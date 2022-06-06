package com.example.mtc_app_04;

public class CorrectiveReportFormHelperClass {

   String eqName, prodLine, plant, inputTime, probDesc, eqDate, eqTime, statusReport;
   Long convDate;

   public CorrectiveReportFormHelperClass(String eqName, String prodLine, String plant, String inputTime, String probDesc, String eqDate, String eqTime, Long convDate , String statusReport) {
      this.eqName = eqName;
      this.prodLine = prodLine;
      this.plant = plant;
      this.inputTime = inputTime;
      this.probDesc = probDesc;
      this.eqDate = eqDate;
      this.eqTime = eqTime;
      this.statusReport = statusReport;
      this.convDate = convDate;
   }


   public String getEqName() {
      return eqName;
   }

   public void setEqName(String eqName) {
      this.eqName = eqName;
   }

   public String getProdLine() {
      return prodLine;
   }

   public void setProdLine(String prodLine) {
      this.prodLine = prodLine;
   }

   public String getPlant() {
      return plant;
   }

   public void setPlant(String plant) {
      this.plant = plant;
   }

   public String getInputTime() {
      return inputTime;
   }

   public void setInputTime(String inputTime) {
      this.inputTime = inputTime;
   }

   public String getProbDesc() {
      return probDesc;
   }

   public void setProbDesc(String probDesc) {
      this.probDesc = probDesc;
   }

   public String getEqDate() {
      return eqDate;
   }

   public void setEqDate(String eqDate) {
      this.eqDate = eqDate;
   }

   public String getEqTime() {
      return eqTime;
   }

   public void setEqTime(String eqTime) {
      this.eqTime = eqTime;
   }

   public String getStatusReport() {
      return statusReport;
   }

   public void setStatusReport(String statusReport) {
      this.statusReport = statusReport;
   }

   public Long getConvDate() {
      return convDate;
   }

   public void setConvDate(Long convDate) {
      this.convDate = convDate;
   }
}