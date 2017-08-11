package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 LEFT chanName userName [{reason}]
 */
public class Left implements Command<String> {

    private ServerState serverState;

    public Left(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");

        if (parser.hasNext(" ")){
            String userName = parser.getString(" ");
            String reason = parser.getString();

            serverState.getChannels().stream().filter(channel -> channel.getChanName().equals(chanName)).findAny().ifPresent(channel -> channel.getClients().remove(userName));
        }else {
            String userName = parser.getString();
            String reason = "";

            serverState.getChannels().stream().filter(channel -> channel.getChanName().equals(chanName)).findAny().ifPresent(channel -> channel.getClients().remove(userName));
        }
    }
}
