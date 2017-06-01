package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;

import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * UPDATEBATTLEINFO battleID spectatorCount locked mapHash {mapName}
 */
public class UpdateBattleInfo implements Command{
    private String line;
    private ServerState serverState;

    public UpdateBattleInfo(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleId = parser.getInt(" ");
        String spectatorCount = parser.getString(" ");
        String locked = parser.getString(" ");
        int mapHash = parser.getInt(" ");
        String mapName = parser.getString();

        serverState.getBattles().stream().filter(battle -> battle.getBattleId()==battleId).findAny().ifPresent(battle -> {
            battle.setMapHash(mapHash);
            battle.setMapName(mapName);
            battle.setLocked(locked);
            battle.setSpectatorCount(spectatorCount);
        });
    }
}
