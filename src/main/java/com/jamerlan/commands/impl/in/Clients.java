package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.model.Channel;

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

        serverState.getChannels().stream().filter(channel -> channel.getChanName().equals(chanName)).findAny().ifPresent(channel -> {
            while(parser.hasNext(" ")){
                String client = parser.getString(" ");
                channel.getClients().add(client);
            }
        });
    }
}
