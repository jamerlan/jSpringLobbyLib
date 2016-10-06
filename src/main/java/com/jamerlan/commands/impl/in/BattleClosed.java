package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

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

        Iterator<Battle> iterator = serverState.getBattles().iterator();
        while (iterator.hasNext()){
            Battle battle = iterator.next();
            if(battle.getBattleId()==battleID){
                iterator.remove();
            }
        }
    }
}
