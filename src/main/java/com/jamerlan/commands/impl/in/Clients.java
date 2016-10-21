package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchChannel;

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

        SearchChannel searchChannel = new SearchChannel();
        com.jamerlan.model.Channel channel = searchChannel.byChanName(serverState, chanName);
        while(parser.hasNext(" ")){
            String client = parser.getString(" ");
            channel.getClients().add(client);
        }
    }
}
