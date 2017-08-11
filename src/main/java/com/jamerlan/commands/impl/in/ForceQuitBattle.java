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
public class ForceQuitBattle implements Command<String> {

    private ServerState serverState;

    public ForceQuitBattle (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        serverState.getAccount().setBattleID(-1);
        System.out.println("YOU ARE KICKED FROM BATTLE!");
    }
}
