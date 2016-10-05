package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAYEX chanName {message}
 */
public class SayEx implements Command {
    private String chanName;
    private String message;

    public SayEx(String chanName, String message) {
        this.chanName = chanName;
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAYEX " + chanName + " " + message);
    }
}
