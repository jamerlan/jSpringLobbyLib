package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOIN chanName
 */
public class Join implements Command {
    private String line;
    private ServerState serverState;

    public Join (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString();

        for (com.jamerlan.model.Channel channel:serverState.getChannels()) {
            if(chanName.equals(channel.getChanName())) {
                serverState.getMyUser().getChannelList().add(channel);
            }
        }

    }
}
