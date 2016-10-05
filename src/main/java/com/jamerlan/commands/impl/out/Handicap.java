package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 HANDICAP userName value
 */
public class Handicap implements Command {
    private String userName;
    private int value;

    public Handicap(String userName, int value) {
        this.userName = userName;
        this.value = value;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("HANDICAP " + userName + " " + value);
    }
}
