package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 ADDSTARTRECT allyNo left top right bottom
 */
public class AddStartRect implements Command<String> {

    private ServerState serverState;

    public AddStartRect(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int allyno = parser.getInt(" ");
        String left = parser.getString(" ");
        String top = parser.getString(" ");
        String right = parser.getString(" ");
        String bottom = parser.getString();
    }
}
