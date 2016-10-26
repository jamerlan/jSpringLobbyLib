package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 IGNORE userName=value [{reason=value}]
 */
public class Ignore implements Command {
    private String line;
    private ServerState serverState;

    public Ignore (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userNameWord = parser.getString("=");
        String userName = parser.getString("\t");

        if (parser.hasNext("=")){
            String reasonWord = parser.getString("=");
            String reason = parser.getString();
            serverState.getIgnoreList().put(userName,reason);
        }else {
            serverState.getIgnoreList().put(userName, " ");
        }
    }
}
