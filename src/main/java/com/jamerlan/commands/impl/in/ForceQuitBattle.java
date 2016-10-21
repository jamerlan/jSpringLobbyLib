package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * FORCEQUITBATTLE
 *
 */
public class ForceQuitBattle implements Command {
    private String line;
    private ServerState serverState;

    public ForceQuitBattle (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        serverState.getAccount().setBattleID(-1);
        System.out.println("YOU ARE KICKED FROM BATTLE!");
    }
}
