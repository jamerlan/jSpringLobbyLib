package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 RING userName
 TODO: client should play the "ring" sound
 */
public class Ring implements Command {
    private String line;
    private ServerState serverState;

    public Ring(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString();
        if (userName==serverState.getAccount().getLogin()){
            System.out.println("RING!!!!!");
        }
    }
}