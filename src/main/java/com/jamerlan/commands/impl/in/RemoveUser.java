package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/*REMOVEUSER userName*/

public class RemoveUser implements Command {
    private String line;
    private ServerState serverState;

    public RemoveUser(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString();
        Iterator<User> iterator = serverState.getUsersOnline().iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getUserName().equals(userName)){
                iterator.remove();
            }
        }
    }
}
