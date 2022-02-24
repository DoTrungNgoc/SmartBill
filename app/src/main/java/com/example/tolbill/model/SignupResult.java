package com.example.tolbill.model;

public class SignupResult {
    private String status;
    private String error;

    public SignupResult() {
    }

    public SignupResult(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResultSignup{" +
                "status='" + status + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
