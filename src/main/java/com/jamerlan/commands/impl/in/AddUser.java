package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 //ADDUSER [DoR]Isildur[teh] US 0
 */
public class AddUser implements Command{
    private String line;
    private ServerState serverState;

    public AddUser(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString(" ");
        String country = parser.getString(" ");
        String accountId = parser.getString();

        serverState.getUsersOnline().stream().filter(u -> u.getUserName().equals(userName)).peek((u) -> {
            u.setCountry(country);
            u.setAccountId(accountId);
        }).findFirst().ifPresent(user1 -> serverState.getUsersOnline().add(user1));
    }
}