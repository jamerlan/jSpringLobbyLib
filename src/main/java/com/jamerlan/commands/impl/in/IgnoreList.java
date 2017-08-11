package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 IGNORELIST userName=value [{reason=value}]
 */
public class IgnoreList implements Command<String> {

    private ServerState serverState;

    public IgnoreList (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userNameWord = parser.getString("=");
        String userName = parser.getString("\t");

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
