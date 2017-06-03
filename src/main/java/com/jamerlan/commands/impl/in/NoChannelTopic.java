package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 NOCHANNELTOPIC chanName
 */
public class NoChannelTopic implements Command {
    private String line;
    private ServerState serverState;

    public NoChannelTopic(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString();

        serverState.getChannels().stream().filter(channel -> channel.getChanName().equals(chanName)).findAny().ifPresent(channel -> {
            channel.setTopic("");
            channel.setTopicChangedTime("");
            channel.setTopicAuthor("");
        });
    }
}
