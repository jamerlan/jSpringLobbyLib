package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 LEFT chanName userName [{reason}]
 */
public class Left implements Command {
    private String line;
    private ServerState serverState;

    public Left(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");

        if (parser.hasNext(" ")){
            String userName = parser.getString(" ");
            String reason = parser.getString();
            for (com.jamerlan.model.Channel channel:serverState.getChannels()) {
                if(chanName.equals(channel.getChanName())) {
                    channel.getClients().remove(userName);
                }
            }
        }else {
            String userName = parser.getString();
            String reason = "";
            for (com.jamerlan.model.Channel channel:serverState.getChannels()) {
                if (chanName.equals(channel.getChanName())) {
                    channel.getClients().remove(userName);
                }
            }
        }
    }
}
