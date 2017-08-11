package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.model.Channel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 JOIN chanName
 */
public class Join implements Command<String> {

    private ServerState serverState;

    public Join (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString();

        serverState.getChannels().stream().filter(channel1 -> channel1.getChanName().equals(chanName)).findAny().ifPresent(channel1 -> serverState.getAccount().getChannelList().add(channel1));
    }
}
