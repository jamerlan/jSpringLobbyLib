package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 UPDATEBOT name battleStatus teamColor
 */
public class UpdateBot implements Command {
    private String name;
    private String battleStatus;
    private String teamColor;

    public UpdateBot(String name, String battleStatus, String teamColor) {
        this.name = name;
        this.battleStatus = battleStatus;
        this.teamColor = teamColor;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("UPDATEBOT " + name + " " + battleStatus + " " + teamColor);
    }
}
