package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAY chanName {message}
 */
public class Say implements Command<PrintWriter> {
    private String chanName;
    private String message;

    public Say(String chanName, String message) {
        this.chanName = chanName;
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAY " + chanName + " " + message);
    }
}
