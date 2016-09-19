package com.jamerlan.model;
/*
* BATTLEOPENED battleID type natType founder ip port
* maxPlayers passworded rank mapHash {engineName} {engineVersion} {map} {title} {gameName}
* */
public class OpenedBattle {
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
//    private String engineName;
//    private String engineVersion;
//    private String map;
//    private String gameName;
//    private String title;


    public OpenedBattle(String battleId, String type, String natType, String fouder, String ip, String port,
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

//    public String getMap() {
//        return map;
//    }

//    public String getEngineName() {
//        return engineName;
//    }
//
//    public String getEngineVersion() {
//        return engineVersion;
//    }

//    public String getTitle() {
//        return title;
//    }
//
//    public String getGameName() {
//        return gameName;
//    }

    @Override
    public String toString() {
        return "OpenedBattle{" +
                "battleId='" + battleId + '\'' +
                ", type='" + type + '\'' +
                ", natType='" + natType + '\'' +
                ", fouder='" + fouder + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", maxPlayers='" + maxPlayers + '\'' +
                ", passworded='" + passworded + '\'' +
                ", rank='" + rank + '\'' +
                ", mapHash='" + mapHash + '\'' +
//                ", engineName='" + engineName + '\'' +
//                ", engineVersion='" + engineVersion + '\'' +
//                ", map='" + map + '\'' +
//                ", title='" + title + '\'' +
//                ", gameName='" + gameName + '\'' +
                '}';
    }
}
