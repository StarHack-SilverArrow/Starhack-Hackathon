package com.example.silverarrowmobileapp.Model;

public class Rezervation {
    private String rezervationId;
    private String applierId;
    private String appliedId;
    private String date;
    private boolean isPayed;

    public Rezervation(String rezervationId, String applierId, String appliedId, String date, boolean isPayed) {
        this.rezervationId = rezervationId;
        this.applierId = applierId;
        this.appliedId = appliedId;
        this.date = date;
        this.isPayed = isPayed;
    }

    public String getRezervationId() {
        return rezervationId;
    }

    public String getApplierId() {
        return applierId;
    }

    public String getAppliedId() {
        return appliedId;
    }

    public String getDate() {
        return date;
    }

    public boolean isPayed() {
        return isPayed;
    }
}
