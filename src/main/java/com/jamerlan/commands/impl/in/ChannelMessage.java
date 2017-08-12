package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 CHANNELMESSAGE chanName message
 */
public class ChannelMessage implements Command<String> {

    private ServerState serverState;

    public ChannelMessage(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString("\t");
        String message = parser.getString();

        System.out.println(commandName + " " + chanName + " " + message);
    }
}
