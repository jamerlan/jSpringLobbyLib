package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Bot;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 ADDBOT battleID name owner battleStatus teamColor {ai dll}
 */
public class AddBot implements Command<String> {

    private ServerState serverState;

    public AddBot(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleID = parser.getInt(" ");
        String name = parser.getString(" ");
        String owner = parser.getString(" ");
        String battleStatus = parser.getString(" ");
        String teamColor = parser.getString();

        Bot bot = new Bot(name, owner, " ");
        bot.setBattleStatus(battleStatus);
        bot.setTeamColor(teamColor);
        serverState.getUsersOnline().add(bot);
        serverState.getBattles().stream().sorted().filter(b -> b.getBattleId()==(battleID)).forEach((b)->b.getUsers().add(bot));

    }
}
