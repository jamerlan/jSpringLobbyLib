package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 REMOVEBOT battleID name
 */
public class RemoveBot implements Command<String> {

    private ServerState serverState;

    public RemoveBot(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleID = parser.getInt(" ");
        String name = parser.getString();

        serverState.getUsersOnline().stream().filter(user -> user.getUserName().equals(name)).findAny().ifPresent(user -> serverState.getUsersOnline().remove(user));
    }
}