package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 ENABLEUNITS unitName1 [unitName2] [...]
 */
public class EnableUnits implements Command<String> {

    private ServerState serverState;

    public EnableUnits(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        while(parser.hasNext(" ")){
            serverState.getUnitsBlackList().remove(parser.getString(" "));
        }
    }
}
