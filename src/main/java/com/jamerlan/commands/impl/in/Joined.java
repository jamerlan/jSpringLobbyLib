package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchChannel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOINED chanName userName
 */
public class Joined implements Command {
    private String line;
    private ServerState serverState;

    public Joined(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        String userName = parser.getString();

        serverState.getChannels().stream().filter(channel -> channel.getChanName().equals(chanName)).findAny().ifPresent(channel -> channel.getClients().add(userName));
    }
}
