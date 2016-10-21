package com.jamerlan.utils;

import com.jamerlan.ServerState;
import com.jamerlan.model.Battle;

import java.util.Iterator;

/**
 * Created by Elt on 21.10.2016.
 */
public class SearchBattle{
    private ServerState serverState;
    private int battleID;
    private int port;

    public Battle byBattleId(ServerState serverState, int battleID){
        this.serverState = serverState;
        this.battleID = battleID;
        Battle searchedBattle = null;
        Iterator<Battle> iterator = serverState.getBattles().iterator();
        while (iterator.hasNext()){
            Battle battle = iterator.next();
            if(battle.getBattleId()==battleID){
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
        this.serverState = serverState;
        this.port = port;
        Battle searchedBattle = null;
        Iterator<Battle> iterator = serverState.getBattles().iterator();
        while (iterator.hasNext()){
            Battle battle = iterator.next();
            if(battle.getPort()==port){
                searchedBattle = battle;
            }
        }
        return searchedBattle;
    }
}
