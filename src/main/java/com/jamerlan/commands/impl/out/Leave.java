package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 LEAVE chanName
 */
public class Leave implements Command<PrintWriter> {
    private String chanName;

    public Leave(String chanName) {
        this.chanName = chanName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("LEAVE " + chanName);
    }
}
