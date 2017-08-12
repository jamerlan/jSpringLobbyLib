package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 OPENBATTLE battleID
 Sent to a client who previously sent a OPENBATTLE command, if the client's request to open a new battle has been approved.
 If the server rejected the request, the client is notified via the OPENBATTLEFAILED command. The server first sends a
 BATTLEOPENED, then this command (this is important - the client must have the battle in his battle list before he receives
 this command!).
 TODO: this command don't create object Battle in Battles List. Then do what?
 */
public class OpenBattle implements Command<String> {

    private ServerState serverState;

    public OpenBattle(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleID = parser.getInt();

        serverState.getBattles().stream().filter(battle -> battle.getBattleId()==battleID).findAny().ifPresent(battle -> serverState.setHostedBattle(battle));
    }
}
