package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 FORCELEAVECHANNEL chanName userName [{reason}]
 */
public class ForceLeaveChannel implements Command<String> {

    private ServerState serverState;

    public ForceLeaveChannel(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        String userName = parser.getString("/t");
        String reason = parser.getString();
    }
}
