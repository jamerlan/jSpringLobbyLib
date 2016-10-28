package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchUser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 IGNORELIST userName=value [{reason=value}]
 */
public class IgnoreList implements Command {
    private String line;
    private ServerState serverState;

    public IgnoreList (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userNameWord = parser.getString("=");
        String userName = parser.getString("\t");
        SearchUser searchUser = new SearchUser();
        User user = searchUser.byUserName(serverState, userName);

        if (parser.hasNext("=")){
            String reasonWord = parser.getString("=");
            String reason = parser.getString();
            serverState.getIgnoreList().put(userName,reason);
            System.out.println(reason);
        }else{
            serverState.getIgnoreList().put(userName," ");
        }

    }
}
