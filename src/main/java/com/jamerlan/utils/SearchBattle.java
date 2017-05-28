package com.jamerlan.utils;

import com.jamerlan.ServerState;
import com.jamerlan.model.Battle;

public class SearchBattle implements Comparable{

    public Battle byBattleId(ServerState serverState, int battleID){
        Battle searchedBattle = null;
        for (Battle battle : serverState.getBattles()) {
            if (battle.getBattleId() == battleID) {
                searchedBattle = battle;
            }
        }
        if (searchedBattle==null){
            Battle newBattle = new Battle(battleID);
            serverState.getBattles().add(newBattle);
            searchedBattle = newBattle;
        }
        return searchedBattle;

    }

    public Battle byPort(ServerState serverState, int port){
        Battle searchedBattle = null;
        for (Battle battle : serverState.getBattles()) {
            if (battle.getPort() == port) {
                searchedBattle = battle;
            }
        }
        return searchedBattle;
    }

    @Override
    public int compareTo(Object o) {
        Battle battle = (Battle) o;
        return 0;
    }
}
