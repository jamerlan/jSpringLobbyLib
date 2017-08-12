package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 MYSTATUS status
 */
public class MyStatus implements Command<PrintWriter> {
    private int inGame;
    private int away;

    public void setInGame(int inGame) {
        this.inGame = inGame;
    }

    public void setAway(int away) {
        this.away = away;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        String temp = inGame + away + "00000";
        Long status = Long.parseLong(temp, 2);
        writer.println("MYSTATUS " + status);
    }
}
