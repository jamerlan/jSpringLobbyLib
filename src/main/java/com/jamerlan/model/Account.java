package com.jamerlan.model;

import java.util.ArrayList;

public class Account {
    private final String login;
    private final String password;
    private final int cpu;
    private final String localIp;
    private final String lobbyNameAndVersion;
    private final int userId;
    private int battleID;
    private ArrayList<Channel> channelList;

    public Account(String login, String password, int cpu, String localIp, String lobbyNameAndVersion, int userId) {
        this.login = login;
        this.password = password;
        this.cpu = cpu;
        this.localIp = localIp;
        this.lobbyNameAndVersion = lobbyNameAndVersion;
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getCpu() {
        return cpu;
    }

    public String getLocalIp() {
        return localIp;
    }

    public String getLobbyNameAndVersion() {
        return lobbyNameAndVersion;
    }

    public int getUserId() {
        return userId;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(ArrayList<Channel> channelList) {
        this.channelList = channelList;
    }

    public int getBattleID() {
        return battleID;
    }

    public void setBattleID(int battleID) {
        this.battleID = battleID;
    }
}
