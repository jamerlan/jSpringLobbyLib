package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 CLIENTS chanName {clients}
 */
public class Clients implements Command {
    private String line;
    private ServerState serverState;

    public Clients(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        ArrayList<String> clientsList = new ArrayList<>();
        while(parser.hasNext(" ")){
            clientsList.add(parser.getString(" "));
        }
    }
}
