package com.jamerlan.model;

import java.io.Serializable;

/**
 * Created by Elt on 21.10.2016.
 */
public class Bot extends User implements Serializable {
    private String owner;
    private String aiDll;
    public Bot(String name, String owner, String aiDll) {
        super(name);
        this.owner = owner;
        this.aiDll = aiDll;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Bot{" +
                ", name='" + super.getUserName() + '\'' +
                ", owner='" + owner + '\'' +
                ", BattleStatus='" + super.getBattlestatus() + '\'' +
                ", teamColor='" + super.getTeamColor() + '\'' +
                ", aiDll='" + aiDll + '\'' +
                '}';
    }
}
