package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 IGNORELIST userName=value [{reason=value}]
 */
public class IgnoreList implements Command {
    private String line;
    private ServerState serverState;

    public IgnoreList (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString(" ");
        if (parser.hasNext(" ")){
            String reason = parser.getString();
            serverState.getIgnoreList().put(userName,reason);
        }else{
            serverState.getIgnoreList().put(userName,"");
        }
    }
}
