package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Bot;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 UPDATEBOT battleID name battleStatus teamColor
 */
public class UpdateBot implements Command {
    private String line;
    private ServerState serverState;

    public UpdateBot(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleID = parser.getInt(" ");
        String name = parser.getString(" ");
        String battleStatus = parser.getString(" ");
        String teamColor = parser.getString();

        Bot bot = new Bot(name, battleStatus, "");
        bot.setTeamColor(teamColor);
        serverState.getUsersOnline().add(bot);
    }
}
