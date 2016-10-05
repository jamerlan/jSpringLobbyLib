package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 LISTCOMPFLAGS
 */
public class ListCompFlags implements Command {
    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("LISTCOMPFLAGS");
    }
}
