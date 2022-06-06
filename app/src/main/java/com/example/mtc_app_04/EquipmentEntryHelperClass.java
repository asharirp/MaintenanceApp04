package com.example.mtc_app_04;

public class EquipmentEntryHelperClass {

    String eqName, eqNo, prodLine, plant;


    public EquipmentEntryHelperClass(String eqName, String eqNo, String prodLine, String plant) {
        this.eqName = eqName;
        this.eqNo = eqNo;
        this.prodLine = prodLine;
        this.plant = plant;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public String getEqNo() {
        return eqNo;
    }

    public void setEqNo(String eqNo) {
        this.eqNo = eqNo;
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
}
