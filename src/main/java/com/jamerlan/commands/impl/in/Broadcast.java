package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 BROADCAST {message}
 */
public class Broadcast implements Command<String> {

    private ServerState serverState;

    public Broadcast(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String message = parser.getString();

        System.out.println(commandName + " " + message);
    }
}
