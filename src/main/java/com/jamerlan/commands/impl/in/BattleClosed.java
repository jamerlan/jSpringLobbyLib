package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 BATTLECLOSED battleID
 */
public class BattleClosed implements Command<String> {

    private ServerState serverState;

    public BattleClosed(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        Integer battleID = parser.getInt();

        serverState.getBattles().stream().filter(b -> b.getBattleId()==(battleID)).findFirst().ifPresent(serverState.getBattles()::remove);
    }
}
