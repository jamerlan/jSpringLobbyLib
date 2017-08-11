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
public class Ring implements Command<String> {

    private ServerState serverState;

    public Ring(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString();
        if (userName==serverState.getAccount().getLogin()){
            System.out.println("RING!!!!!");
        }
    }
}