package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

//TASSERVER protocolVersion springVersion udpPort serverMode
//TASServer 0.36 96.0 8201 0
public class TASServer implements Command {
    private String line;
    private ServerState serverState;

    public TASServer (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String protocolVersion = parser.getString(" ");
        String springVersion = parser.getString(" ");
        String udpPort = parser.getString(" ");
        String serverMode = parser.getString();
    }
}
