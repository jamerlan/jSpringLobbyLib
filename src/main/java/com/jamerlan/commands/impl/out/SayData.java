package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAYDATA chanName {message}
 */
public class SayData implements Command<PrintWriter> {
    private String chanName;
    private String message;

    public SayData(String chanName, String message) {
        this.chanName = chanName;
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAYDATA " + chanName + " " + message);
    }
}
