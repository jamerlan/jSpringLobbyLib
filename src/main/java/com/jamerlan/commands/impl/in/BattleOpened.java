package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * BATTLEOPENED battleID type natType founder ip port maxPlayers passworded rank mapHash {engineName} {engineVersion} {map} {title} {gameName}
 *
 * BATTLEOPENED 20535 0 0 EvoRTSDedicated4 54.183.228.213 8254 8 0 0 540337253 Archers Battlefield - v05	Evolution RTS Dedicated Host 4	Evolution RTS - v10.17
 */
public class BattleOpened implements Command {
    private String line;
    private ServerState serverState;

    public BattleOpened(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String first = parser.getString(" ");

        int battleId = parser.getInt(" ");
        int type = parser.getInt(" ");
        int natType = parser.getInt(" ");
        String founder = parser.getString(" ");
        String ip = parser.getString(" ");
        int port = parser.getInt(" ");
        int maxPlayers = parser.getInt(" ");
        int passworded = parser.getInt(" ");
        int rank = parser.getInt(" ");
        int mapHash = parser.getInt(" ");
        String map = parser.getString("\t");
        String title = parser.getString("\t");
        String gameName = parser.getString();

        serverState.getBattles().add(new Battle(new ArrayList<>(), battleId, type, natType, founder, ip, port, maxPlayers, passworded, rank, mapHash, map, title, gameName));
    }
}
