package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 LOGININFOEND
 */
public class LoginInfoEnd implements Command<String> {

    private ServerState serverState;

    public LoginInfoEnd(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser commandParser = new CommandParser(line);
        String commandName = commandParser.getString();
    }
}