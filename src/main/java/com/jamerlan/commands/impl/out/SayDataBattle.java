package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAYDATABATTLE {message}
 */
public class SayDataBattle implements Command {
    private String message;

    public SayDataBattle(String message) {
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAYDATABATTLE " + message);
    }
}
