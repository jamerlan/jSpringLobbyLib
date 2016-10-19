package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 CHANNELTOPIC chanName author changedTime {topic}
 */
public class ChannelTopic implements Command {
    private String line;
    private ServerState serverState;

    public ChannelTopic(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        String author = parser.getString(" ");
        String changedTime = parser.getString(" ");
        String topic = parser.getString();

        System.out.println(commandName + " " + chanName + " " + author + " " + changedTime + " : " + topic);
    }
}
