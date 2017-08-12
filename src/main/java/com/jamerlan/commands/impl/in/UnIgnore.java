package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 UNIGNORE userName=value
 */
public class UnIgnore implements Command<String> {

    private ServerState serverState;

    public UnIgnore(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userNameWord = parser.getString("=");
        String userName = parser.getString();

        serverState.getIgnoreList().remove(userName);
    }
}