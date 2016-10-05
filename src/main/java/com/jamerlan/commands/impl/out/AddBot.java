package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ADDBOT name battleStatus teamColor {ai dll}
 * TODO {ai dll} = ???
 */
public class AddBot implements Command {
    private String name;
    private String battleStatus;
    private String teamColor;

    public AddBot(String name, String battleStatus, String teamColor) {
        this.name = name;
        this.battleStatus = battleStatus;
        this.teamColor = teamColor;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("ADDBOT " + name + " " + battleStatus + " " + teamColor);
    }
}
