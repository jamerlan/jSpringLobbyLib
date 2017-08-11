package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 REMOVEBOT name
 */
public class RemoveBot implements Command<PrintWriter> {
    private String name;

    public RemoveBot(String name) {
        this.name = name;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("REMOVEBOT " + name);
    }
}
