package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 COMPFLAGS [compFlag1] [compFlag2] [...]
 */
public class CompFlags implements Command<String> {

    private ServerState serverState;

    public CompFlags(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        ArrayList<String> compflags = new ArrayList<>();
        while (parser.hasNext("")){
            compflags.add(parser.getString(" "));
        }
    }
}
