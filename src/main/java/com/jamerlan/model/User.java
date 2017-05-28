package com.jamerlan.model;

import java.io.Serializable;


/**
 ADDUSER [mic]Bedarfsriese DE 0
 ADDUSER [DoR]Isildur[teh] US 0
 ADDUSER amadeustekken FR 0
 ADDUSER [ACE]babar FR 0
 */
public class User implements Serializable, Comparable {
    private final String userName;
    private String country;
    private final int cpu = 0;
    private String accountId;
    private String status;
    private String battleStatus;
    private String teamColor;
    private String ip;
    private int port;
    private Channel channel; //need for SAYPRIVATE Command

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String battleStatus, String teamColor) {
        this.userName = userName;
        this.battleStatus = battleStatus;
        this.teamColor = teamColor;
    }

    public User(String userName, String status) {
        this.userName = userName;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public String getCountry() {
        return country;
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

    public String getBattleStatus() {
        return battleStatus;
    }

    public void setBattleStatus(String battlestatus) {
        this.battleStatus = battlestatus;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", cpu='" + cpu + '\'' +
                ", accountId='" + accountId + '\'' +
                ", status='" + status + '\'' +
                ", battlestatus='" + battleStatus + '\'' +
                ", teamColor='" + teamColor + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;

        return 0;
    }
}
