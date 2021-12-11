package com.example.silverarrowmobileapp.Model;

public class Application {
    private String applicationId;
    private boolean isAccepted;
    private boolean isDeclined;
    private String applierId;
    private String appliedId;

    public Application(String applicationId, boolean isAccepted, boolean isDeclined, String applierId, String appliedId) {
        this.applicationId = applicationId;
        this.isAccepted = isAccepted;
        this.isDeclined = isDeclined;
        this.applierId = applierId;
        this.appliedId = appliedId;
    }

    public Application(Application app) {
        app.applicationId = applicationId;
        app.isAccepted = isAccepted;
        app.isDeclined = isDeclined;
        app.applierId = applierId;
        app.appliedId = appliedId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public boolean isDeclined() {
        return isDeclined;
    }

    public String getApplierId() {
        return applierId;
    }

    public String getAppliedId() {
        return appliedId;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setDeclined(boolean declined) {
        isDeclined = declined;
    }
}
