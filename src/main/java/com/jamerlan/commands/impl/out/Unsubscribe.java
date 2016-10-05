package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 UNSUBSCRIBE chanName
 Examples
 UNSUBSCRIBE chanName=sy
 */
public class Unsubscribe implements Command {
    private String chanName;

    public Unsubscribe(String chanName) {
        this.chanName = chanName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("UNSUBSCRIBE chanName=" + chanName);
    }
}
