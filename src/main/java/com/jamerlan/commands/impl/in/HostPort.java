package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 HOSTPORT port
 */
public class HostPort implements Command<String> {

    private ServerState serverState;

    public HostPort (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int port = parser.getInt();

        serverState.getBattles().stream().filter(battle -> battle.getPort()==port).findAny().ifPresent(battle -> battle.setPort(port)); //test it!
    }
}
