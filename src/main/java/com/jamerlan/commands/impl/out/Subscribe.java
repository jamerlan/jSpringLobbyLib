package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SUBSCRIBE chanName
 */
public class Subscribe implements Command<PrintWriter> {
    private String chanName;

    public Subscribe(String chanName) {
        this.chanName = chanName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SUBSCRIBE chanName=" + chanName);

    }
}
