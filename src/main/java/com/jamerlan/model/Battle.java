package com.jamerlan.model;

import java.util.HashSet;
import java.util.Set;

public class Battle {
    private Set<User> users;
    private int battleId;
    private int type;
    private int natType;
    private String fouder;
    private String ip;
    private int port;
    private int maxPlayers;
    private int passworded;
    private int rank;
    private int mapHash;
    private String locked;
    private String spectatorCount;
//    private String engineName;
//    private String engineVersion;
    private String mapName;
    private String gameName;
    private String title;
    private Channel channel; //need for SAIDBATTLE Command

    public Battle(HashSet<User> users, int battleId, int type, int natType, String fouder, String ip, int port,
                  int maxPlayers, int passworded, int rank, int mapHash) {
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

    public Battle(HashSet<User> users, int battleId) {
        this.users = users;
        this.battleId = battleId;
    }

    public Battle(int battleId) {
        this.battleId = battleId;
    }

    public Battle(HashSet<User> users, int battleId, int type, int natType, String fouder, String ip, int port, int maxPlayers, int passworded, int rank, int mapHash, String mapName, String title, String gameName) {
        this.users = users;
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
        this.mapName = mapName;
        this.title = title;
        this.gameName = gameName;
    }

    public int getBattleId() {
        return battleId;
    }

    public int getType() {
        return type;
    }

    public int getNatType() {
        return natType;
    }

    public String getFouder() {
        return fouder;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getPassworded() {
        return passworded;
    }

    public int getRank() {
        return rank;
    }

    public int getMapHash() {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void removeUser(String userName) {
        users.remove(userName);
    }

    public void setBattleId(int battleId) {
        this.battleId = battleId;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setNatType(int natType) {
        this.natType = natType;
    }

    public void setFouder(String fouder) {
        this.fouder = fouder;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setPassworded(int passworded) {
        this.passworded = passworded;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setMapHash(int mapHash) {
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

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
