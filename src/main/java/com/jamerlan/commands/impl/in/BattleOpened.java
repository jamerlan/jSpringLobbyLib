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
        System.out.println(first);

        int battleId = parser.getInt(" ");
        System.out.println(battleId);
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getString(" "));
        System.out.println(parser.getString(" "));//ip
        System.out.println(parser.getInt(" "));//port
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        String map = parser.getString("\t");
        System.out.println(map);
        String title = parser.getString("\t");
        System.out.println(title);
        String gameName = parser.getString();
        System.out.println(gameName);

        serverState.getBattles().add(new Battle(new ArrayList<>(), battleId));
    }
}
