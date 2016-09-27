package com.jamerlan.model;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    private List<String> users;
    private String battleId;
    private String type;
    private String natType;
    private String fouder;
    private String ip;
    private String port;
    private String maxPlayers;
    private String passworded;
    private String rank;
    private String mapHash;
    private String locked;
    private String spectatorCount;
//    private String engineName;
//    private String engineVersion;
    private String mapName;
//    private String gameName;
//    private String title;

//    public Battle(ArrayList<String> users, String battleId, String spectatorCount, String locked, String mapHash, String mapName) {
//        this.users = users;
//        this.battleId = battleId;
//        this.mapHash = mapHash;
//        this.locked = locked;
//        this.spectatorCount = spectatorCount;
//        this.mapName = mapName;
//    }

    public Battle(ArrayList<String> users, String battleId, String type, String natType, String fouder, String ip, String port,
                  String maxPlayers, String passworded, String rank, String mapHash) {
        this.battleId = battleId;
        this.type = type;
        this.natType = natType;
        this.fouder = fouder;
        this.ip = ip;
        this.port = port;
        this.maxPlayers = maxPlayers;
        this.passworded = passworded;
        this.rank = rank;
        this.mapHash = mapHash;
//        this.engineName = engineName;
//        this.engineVersion = engineVersion;
//        this.map = map;
//        this.gameName = gameName;
//        this.title = title;
        this.users = users;
    }

    public Battle(List<String> users, String battleId) {
        this.users = users;
        this.battleId = battleId;
    }

    public String getBattleId() {
        return battleId;
    }

    public String getType() {
        return type;
    }

    public String getNatType() {
        return natType;
    }

    public String getFouder() {
        return fouder;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getMaxPlayers() {
        return maxPlayers;
    }

    public String getPassworded() {
        return passworded;
    }

    public String getRank() {
        return rank;
    }

    public String getMapHash() {
        return mapHash;
    }

    public String getLocked() {
        return locked;
    }

    public String getSpectatorCount() {
        return spectatorCount;
    }

    public String getMapName() {
        return mapName;
    }

    public List getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public void addUser(String userName) {
        users.add(userName);
    }

    public void removeUser(String userName) {
        users.remove(userName);
    }

    public void setBattleId(String battleId) {
        this.battleId = battleId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNatType(String natType) {
        this.natType = natType;
    }

    public void setFouder(String fouder) {
        this.fouder = fouder;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setMaxPlayers(String maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setPassworded(String passworded) {
        this.passworded = passworded;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setMapHash(String mapHash) {
        this.mapHash = mapHash;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public void setSpectatorCount(String spectatorCount) {
        this.spectatorCount = spectatorCount;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "users=" + users +
                ", battleId='" + battleId + '\'' +
                ", type='" + type + '\'' +
                ", natType='" + natType + '\'' +
                ", fouder='" + fouder + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", maxPlayers='" + maxPlayers + '\'' +
                ", passworded='" + passworded + '\'' +
                ", rank='" + rank + '\'' +
                ", mapHash='" + mapHash + '\'' +
                ", locked='" + locked + '\'' +
                ", spectatorCount='" + spectatorCount + '\'' +
                ", mapName='" + mapName + '\'' +
                '}';
    }
}
