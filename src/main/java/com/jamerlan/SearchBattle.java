package com.jamerlan;

import com.jamerlan.model.Battle;

import java.util.List;


public class SearchBattle {

    private List<Battle> battles;
    private Battle battle;

    public SearchBattle(List<Battle> battles) {
        this.battles = battles;
    }

    @Override
    public String toString() {
        return "Searcher{" +
                "battles=" + battles +
                ", battle=" + battle +
                '}';
    }

    public void searchBatle(){
        for (Battle batt:battles){
            System.out.println("             serverState.getBattles = " + batt);
        }
        System.out.println("-----------");
    }

    public List<Battle> getBattles() {
        return battles;
    }

    public Battle getBattle() {
        return battle;
    }
}
