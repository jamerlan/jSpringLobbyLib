package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 FORCEJOINBATTLEFAILED userName [{reason}]
 */
public class ForceJoinBattleFailed implements Command<String> {

    private ServerState serverState;

    public ForceJoinBattleFailed(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString(" ");
        String reason = parser.getString();
    }
}
