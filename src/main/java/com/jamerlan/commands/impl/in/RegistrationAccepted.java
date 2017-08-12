package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 REGISTRATIONACCEPTED
 Sent to a client who has just sent a REGISTER command, if registration has been accepted.
 */
public class RegistrationAccepted implements Command<String> {

    private ServerState serverState;

    public RegistrationAccepted (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        System.out.println(commandName);
    }
}
