package com.jamerlan.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Elt on 20.10.2016.
 */
public class MyUser {
    private final String userName;
    private final String password;
    private final int cpu;
    private final String localIp;
    private final String lobbyNameAndVersion;
    private final int userId;
    private ArrayList<Channel> channelList;
    private HashMap<String, String> ignoreList;

    public MyUser(String userName, String password, int cpu, String localIp, String lobbyNameAndVersion, int userId) {
        this.userName = userName;
        this.password = password;
        this.cpu = cpu;
        this.localIp = localIp;
        this.lobbyNameAndVersion = lobbyNameAndVersion;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
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

    public HashMap<String, String> getIgnoreList() {
        return ignoreList;
    }

    public void setIgnoreList(HashMap<String, String> ignoreList) {
        this.ignoreList = ignoreList;
    }
}
