package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAYBATTLEEX {message}
 */
public class SayBattleEx implements Command {
    private String message;

    public SayBattleEx(String message) {
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAYBATTLEEX " + message);
    }
}
