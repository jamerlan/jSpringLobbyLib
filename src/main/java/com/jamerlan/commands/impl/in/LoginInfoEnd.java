package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 LOGININFOEND
 */
public class LoginInfoEnd implements Command {
    private String line;
    private ServerState serverState;

    public LoginInfoEnd(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser commandParser = new CommandParser(line);
        String commandName = commandParser.getString();
    }
}