package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.commands.impl.out.JoinBattle;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 FORCEJOINBATTLE destinationBattleID [destinationBattlePassword]
 TODO: The receiving client must subsequently comply by sending a JOINBATTLE command to the server. See the Match-Making
 section in the beginning of this document for more details.
 */
public class ForceJoinBattle implements Command {
    private String line;
    private ServerState serverState;

    public ForceJoinBattle(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int destinationBattleID = parser.getInt("/t");
        String destinationBattlePassword = parser.getString();

        com.jamerlan.commands.impl.out.JoinBattle joinBattle = new JoinBattle(destinationBattleID);
        joinBattle.execute(serverState.getConnection().getWriter());
    }
}
