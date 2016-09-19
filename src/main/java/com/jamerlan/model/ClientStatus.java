package com.jamerlan.model;

/**
 CLIENTSTATUS [BoS]Autohost 92
 CLIENTSTATUS BrainDamage 24
 CLIENTSTATUS niggerjim 1
 CLIENTSTATUS userName status
 */
public class ClientStatus {
    private String userName;
    private String status;

    public ClientStatus(String userName, String status) {
        this.userName = userName;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ClientStatus{" +
                "userName='" + userName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
