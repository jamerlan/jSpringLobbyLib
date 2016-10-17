package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * DISABLEUNITS unitName1 [unitName2] [...]
 */
public class DisableUnits implements Command {
    private String line;
    private ServerState serverState;

    public DisableUnits(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        while(parser.hasNext("")){
            serverState.getUnitsBlackList().add(parser.getString(" "));
        }
    }
}

