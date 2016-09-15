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
