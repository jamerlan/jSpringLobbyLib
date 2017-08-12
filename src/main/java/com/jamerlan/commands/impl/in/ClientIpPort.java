package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 CLIENTIPPORT userName ip port
 */
public class ClientIpPort implements Command<String> {

    private ServerState serverState;

    public ClientIpPort(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString(" ");
        String ip = parser.getString(" ");
        int port = parser.getInt();

        serverState.getUsersOnline().stream().filter(user -> user.getUserName().equals(userName)).findAny().ifPresent(user -> {
            user.setIp(ip);
            user.setPort(port);
        });
    }
}
