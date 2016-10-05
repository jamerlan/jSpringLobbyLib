package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 RING userName
 */
public class Ring implements Command {
    private String userName;

    public Ring(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("RING " + userName);
    }
}
