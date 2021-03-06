package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/*REMOVEUSER userName*/

public class RemoveUser implements Command<String> {

    private ServerState serverState;

    public RemoveUser(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString();

        serverState.getUsersOnline().stream().filter(user -> user.getUserName().equals(userName)).findAny().ifPresent(user -> serverState.getUsersOnline().remove(user));
    }
}
