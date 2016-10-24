package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.PrintWriter;

public class MyBattleStatus implements Command{
     private String battleStatus;
     private int teamColor;

    public MyBattleStatus(String battleStatus, int teamColor) {
        this.battleStatus = battleStatus;
        this.teamColor = teamColor;
    }

    @Override
     public void execute(PrintWriter writer){
         writer.println("MYBATTLESTATUS " + battleStatus + " " + teamColor);
     }
}
