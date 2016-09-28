package com.jamerlan.model;

import java.io.Serializable;


/**
 ADDUSER [mic]Bedarfsriese DE 0
 ADDUSER [DoR]Isildur[teh] US 0
 ADDUSER amadeustekken FR 0
 ADDUSER [ACE]babar FR 0
 */
public class User implements Serializable {
    private final String userName;
    private final String country;
    private final String cpu;
    private final String accountId;
    private String status;
    private String battlestatus;

    public User(String userName, String country, String cpu, String accountId) {
        this.userName = userName;
        this.country = country;
        this.cpu = cpu;
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public String getCountry() {
        return country;
    }

    public String getCpu() {
        return cpu;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBattlestatus() {
        return battlestatus;
    }

    public void setBattlestatus(String battlestatus) {
        this.battlestatus = battlestatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", cpu='" + cpu + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
