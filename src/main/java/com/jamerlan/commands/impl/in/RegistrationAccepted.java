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
public class RegistrationAccepted implements Command {
    private String line;
    private ServerState serverState;

    public RegistrationAccepted (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        System.out.println(commandName);
    }
}
