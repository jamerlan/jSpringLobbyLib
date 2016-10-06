package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 CLIENTBATTLESTATUS userName battleStatus teamColor
 TODO battleStatus - field only battle user or global?? etc teamColor
 */
public class ClientBattleStatus implements Command {
    private String line;
    private ServerState serverState;

    public ClientBattleStatus(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString(" ");
        String battleStatus = parser.getString(" ");
        String teamColor = parser.getString();

        for (User user:serverState.usersOnline) {
            if(user.getUserName().equals(userName)){
                user.setBattlestatus(battleStatus);
                user.setTeamColor(teamColor);
            }
        }
    }
}
