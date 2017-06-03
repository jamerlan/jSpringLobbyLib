package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/*REMOVEUSER userName*/

public class RemoveUser implements Command {
    private String line;
    private ServerState serverState;

    public RemoveUser(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString();

        serverState.getUsersOnline().stream().filter(user -> user.getUserName().equals(userName)).findAny().ifPresent(user -> serverState.getUsersOnline().remove(user));
    }
}
