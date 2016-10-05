package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 MUTELIST chanName
 */
public class MuteList implements Command {
    private String chanName;

    public MuteList(String chanName) {
        this.chanName = chanName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("MUTELIST " + chanName);
    }
}
