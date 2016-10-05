package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Elt on 28.09.2016.
 */
public class ClientStatusTest implements Command{

    private String line;
    private ServerState serverState;

    public ClientStatusTest(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String first = parser.getString(" ");

        String userName = parser.getString(" ");
        String status = parser.getString(" ");

        for (User user:serverState.usersOnline) {
            if(user.getUserName().equals(userName)){
                user.setStatus(status);
            }
        }
    }
}