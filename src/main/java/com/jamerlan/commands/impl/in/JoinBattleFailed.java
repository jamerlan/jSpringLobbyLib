package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOINBATTLEFAILED {reason}
 */
public class JoinBattleFailed implements Command<String> {

    private ServerState serverState;

    public JoinBattleFailed (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        if (parser.hasNext(" ")){
            String reason = parser.getString();
        }else {
            String reason = " ";
        }
    }
}
