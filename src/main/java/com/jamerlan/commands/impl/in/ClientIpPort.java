package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchUser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 CLIENTIPPORT userName ip port
 */
public class ClientIpPort implements Command {
    private String line;
    private ServerState serverState;

    public ClientIpPort(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString(" ");
        String ip = parser.getString(" ");
        int port = parser.getInt();

        SearchUser searchUser = new SearchUser();
        User user = searchUser.byUserName(serverState, userName);
        user.setIp(ip);
        user.setPort(port);
    }
}
