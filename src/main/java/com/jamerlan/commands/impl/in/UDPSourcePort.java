package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 UDPSOURCEPORT port
 Sent as a response to a client's UDP packet (used with "hole punching" NAT traversal technique). For more info, see the Hole punching section in the beginnig of this document.

 UDPSOURCEPORT 52361
 */
public class UDPSourcePort implements Command {
    private String line;
    private ServerState serverState;

    public UDPSourcePort (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int port = parser.getInt();
    }
}
