package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SHAREDKEY key_status key_digest [extra_data]
 TODO: delimiter of key_digest can be ""?
 */
public class SharedKey implements Command {
    private String line;
    private ServerState serverState;

    public SharedKey (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String keyStatus = parser.getString(" ");
        String keyDigest = parser.getString(" ");
        if (parser.hasNext("")) {
            String extraData = parser.getString();
        }
    }
}
