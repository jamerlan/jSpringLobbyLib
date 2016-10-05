package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAYBATTLE {message}
 */
public class SayBattle implements Command {
    private String message;

    public SayBattle(String message) {
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAYBATTLE " + message);
    }
}
