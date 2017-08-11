package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.PrintWriter;

public class MyBattleStatus implements Command<PrintWriter>{
//     private String battleStatus;
     private int teamColor;
    private int ready = 0;
    private int teamNo = 1111;
    private int ally = 1111;
    private int mode = 1;
    private int handicap = 1111111;
    private int sync = 11;
    private int side = 1111;

    public void setReady(int ready) {
        this.ready = ready;
    }

    public void setId(int teamNo) {
        this.teamNo = teamNo;
    }

    public void setAlly(int ally) {
        this.ally = ally;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public MyBattleStatus(int teamColor) {
        this.teamColor = teamColor;
    }

    @Override
     public void execute(PrintWriter writer){
        String temp = "0" + ready + teamNo + ally + mode + handicap + "0000" + sync + side + "0000";
        Long battleStatus = Long.parseLong(temp, 2);
        writer.println("MYBATTLESTATUS " + battleStatus + " " + teamColor);
     }
}
