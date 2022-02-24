package com.example.tolbill.model;

public class UploadResult {
    private String status;
    private Bill bill;

    public UploadResult(String status, Bill bill) {
        this.status = status;
        this.bill = bill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "UploadResult{" +
                "status='" + status + '\'' +
                ", bill=" + bill.toString()+
                '}';
    }
}
