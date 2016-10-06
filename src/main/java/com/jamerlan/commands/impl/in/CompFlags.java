package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 COMPFLAGS [compFlag1] [compFlag2] [...]
 */
public class CompFlags implements Command {
    private String line;
    private ServerState serverState;

    public CompFlags(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        ArrayList<String> compflags = new ArrayList<>();
        Iterator<String> iterator = compflags.iterator();
        while(iterator.hasNext()){
            compflags.add(parser.getString(" "));
        }

    }
}
