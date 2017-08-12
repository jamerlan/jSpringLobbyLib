package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *PUBLICKEY server_public_key session_flag_bits
 */
public class PublicKey implements Command<String> {

    private ServerState serverState;

    public PublicKey (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String serverPublicKey = parser.getString(" ");
        int sessionFlagBits = parser.getInt();
    }
}
