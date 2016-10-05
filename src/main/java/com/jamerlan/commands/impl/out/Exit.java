package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 EXIT [{reason}]
 */
public class Exit implements Command {
    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("EXIT");
    }
}
