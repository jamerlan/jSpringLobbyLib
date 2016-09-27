package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class RemoveUser implements Command {
    private String removeUserLine;
    private ServerState serverState;

    public RemoveUser(String removeUserLine, ServerState serverState) {
        this.removeUserLine = removeUserLine;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        String[] removeUserParts = removeUserLine.split(" ");
        System.out.println("Remove command detected!");

        String userName = removeUserParts[1];

        Iterator<User> iterator = serverState.getUsersOnline().iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getUserName().equals(userName)){
                iterator.remove();
                System.out.println("User " + userName + " removed!");
            }
        }
    }
}
