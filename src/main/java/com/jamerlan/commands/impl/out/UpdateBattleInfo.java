package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 UPDATEBATTLEINFO spectatorCount locked mapHash {mapName}
 */
public class UpdateBattleInfo implements Command<PrintWriter> {
    private int spectatorCount;
    private int locked;
    private int mapHash;
    private String mapName;

    public UpdateBattleInfo(int spectatorCount, int locked, int mapHash, String mapName) {
        this.spectatorCount = spectatorCount;
        this.locked = locked;
        this.mapHash = mapHash;
        this.mapName = mapName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("UPDATEBATTLEINFO " + spectatorCount + " " + locked + " " + mapHash + "\t" + mapName);
    }
}
