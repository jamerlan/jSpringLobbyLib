package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * IGNORELIST
 */
public class IgnoreList implements Command<PrintWriter> {
    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("IGNORELIST");
    }
}
