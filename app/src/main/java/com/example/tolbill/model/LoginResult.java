package com.example.tolbill.model;

public class LoginResult {
    private String status;
    private String error;
    private String auth_token;

    public LoginResult(String status, String error, String auth_token) {
        this.status = status;
        this.error = error;
        this.auth_token = auth_token;
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

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "status='" + status + '\'' +
                ", error='" + error + '\'' +
                ", auth_token='" + auth_token + '\'' +
                '}';
    }
}
