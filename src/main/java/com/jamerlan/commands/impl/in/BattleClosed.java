package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchBattle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 BATTLECLOSED battleID
 */
public class BattleClosed implements Command {
    private String line;
    private ServerState serverState;

    public BattleClosed(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        Integer battleID = parser.getInt();

        serverState.getBattles().stream().filter(b -> b.getBattleId()==(battleID)).findFirst().ifPresent(serverState.getBattles()::remove);
    }
}
