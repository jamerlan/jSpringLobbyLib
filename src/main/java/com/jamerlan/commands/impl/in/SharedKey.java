package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SHAREDKEY key_status key_digest [extra_data]
 */
public class SharedKey implements Command<String> {

    private ServerState serverState;

    public SharedKey (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String keyStatus = parser.getString(" ");
        String keyDigest = parser.getString(" ");
        if (parser.hasNext(" ")) {
            String extraData = parser.getString();
        }
    }
}
