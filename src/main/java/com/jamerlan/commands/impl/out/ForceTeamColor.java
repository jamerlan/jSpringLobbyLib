package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 FORCETEAMCOLOR userName color
 */
public class ForceTeamColor implements Command{
    private String userName;
    private String color;

    public ForceTeamColor(String userName, String color) {
        this.userName = userName;
        this.color = color;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("FORCETEAMCOLOR " + userName + " " + color);
    }
}
