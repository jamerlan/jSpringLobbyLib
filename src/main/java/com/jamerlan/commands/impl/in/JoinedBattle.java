package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.utils.SearchBattle;
import com.jamerlan.utils.SearchUser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOINEDBATTLE battleID userName [scriptPassword]
 */
public class JoinedBattle implements Command{
    private String line;
    private ServerState serverState;

    public JoinedBattle(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleId = parser.getInt(" ");
        String userName = parser.getString();

        SearchBattle searchBattle = new SearchBattle();
        Battle battle = searchBattle.byBattleId(serverState, battleId);
        SearchUser searchUser = new SearchUser();
        User user = searchUser.byUserName(serverState, userName);
        battle.getUsers().add(user);
    }
}
