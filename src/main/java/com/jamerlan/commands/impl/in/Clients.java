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
public class Clients implements Command<String> {

    private ServerState serverState;

    public Clients(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
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
