package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * CONNECTUSERFAILED userName [{reason}]
 */
public class ConnectUserFailed implements Command<String>{

    private ServerState serverState;

    public ConnectUserFailed(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString("/t");
        if (parser.hasNext("")){
            String reason = parser.getString();
        }else {
            String reason = "";
        }
    }
}
