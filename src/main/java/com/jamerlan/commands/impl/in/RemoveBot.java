package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchUser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 REMOVEBOT battleID name
 */
public class RemoveBot implements Command {
    private String line;
    private ServerState serverState;

    public RemoveBot(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleID = parser.getInt(" ");
        String name = parser.getString();

        serverState.getUsersOnline().stream().filter(user -> user.getUserName().equals(name)).findAny().ifPresent(user -> serverState.getUsersOnline().remove(user));
    }
}