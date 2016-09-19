package com.jamerlan.model;

/**
 LEFTBATTLE 19784 niggerjim
 LEFTBATTLE battleID userName
 */
public class LeftBattle {
    private String battleId;
    private String userName;

    public LeftBattle(String battleId, String userName) {
        this.battleId = battleId;
        this.userName = userName;
    }

    public String getBattleId() {
        return battleId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "LeftBattle{" +
                "battleId='" + battleId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
