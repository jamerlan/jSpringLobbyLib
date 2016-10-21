package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchBattle;

import java.io.IOException;
import java.io.PrintWriter;

/**
 HOSTPORT port
 */
public class HostPort implements Command {
    private String line;
    private ServerState serverState;

    public HostPort (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int port = parser.getInt();

        SearchBattle searchBattle = new SearchBattle();
        Battle battle = searchBattle.byPort(serverState, port);
        battle.setPort(port);
    }
}
