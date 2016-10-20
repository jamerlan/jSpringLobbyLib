package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 CHANNEL chanName userCount [{topic}]
 */
public class Channel implements Command {
    private String line;
    private ServerState serverState;

    public Channel(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        String userCount = parser.getString(" ");
        if (parser.hasNext(" ")){
            String topic = parser.getString();
        }else {
            String topic = "";
        }

    }
}
