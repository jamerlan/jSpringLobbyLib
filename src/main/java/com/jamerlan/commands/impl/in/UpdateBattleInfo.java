package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;

import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchBattle;

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

        SearchBattle searchBattle = new SearchBattle();
        Battle battle = searchBattle.byBattleId(serverState, battleId);
        battle.setMapHash(mapHash);
        battle.setMapName(mapName);
        battle.setLocked(locked);
        battle.setSpectatorCount(spectatorCount);
    }
}
