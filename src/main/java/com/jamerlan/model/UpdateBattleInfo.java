package com.jamerlan.model;

/**
 UPDATEBATTLEINFO 19578 1 0 -848511687 Volcanic Basin - v04
 UPDATEBATTLEINFO 19582 1 0 474083723 Fetid Marsh - v07
 UPDATEBATTLEINFO battleID spectatorCount locked mapHash {mapName}
 */
public class UpdateBattleInfo {
    private String battleId;
    private String spectatorCount;
    private String locked;
    private String mapHash;
    private String mapName;

    public UpdateBattleInfo(String battleId, String spectatorCount, String locked, String mapHash, String mapName) {
        this.battleId = battleId;
        this.spectatorCount = spectatorCount;
        this.locked = locked;
        this.mapHash = mapHash;
        this.mapName = mapName;
    }

    public String getBattleId() {
        return battleId;
    }

    public String getSpectatorCount() {
        return spectatorCount;
    }

    public String getLocked() {
        return locked;
    }

    public String getMapHash() {
        return mapHash;
    }

    public String getMapName() {
        return mapName;
    }

    @Override
    public String toString() {
        return "UpdateBattleInfo{" +
                "battleId='" + battleId + '\'' +
                ", spectatorCount='" + spectatorCount + '\'' +
                ", locked='" + locked + '\'' +
                ", mapHash='" + mapHash + '\'' +
                ", mapName='" + mapName + '\'' +
                '}';
    }
}
