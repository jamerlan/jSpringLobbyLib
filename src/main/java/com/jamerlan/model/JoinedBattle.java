package com.jamerlan.model;

/**
 * Created by Elt on 16.09.2016.
 */
//JOINEDBATTLE 19784 wolfen
//JOINEDBATTLE 19784 rooks[vegan]
//JOINEDBATTLE 19784 [Fx]Buzz
//JOINEDBATTLE battleID userName [scriptPassword]
public class JoinedBattle {
    private String battleId;
    private String userName;

    public JoinedBattle(String battleId, String userName) {
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
        return "JoinedBattle{" +
                "battleId='" + battleId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

