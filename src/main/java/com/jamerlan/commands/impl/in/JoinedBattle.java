package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 JOINEDBATTLE battleID userName [scriptPassword]
 */
public class JoinedBattle implements Command<String>{

    private ServerState serverState;

    public JoinedBattle(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        int battleId = parser.getInt(" ");
        String userName = parser.getString();

        Optional<User> user = serverState.getUsersOnline().stream().filter(user1 -> user1.getUserName().equals(userName)).findAny();
        serverState.getBattles().stream().filter(battle -> battle.getBattleId()==battleId).findAny().ifPresent(battle -> user.ifPresent(user1 -> battle.getUsers().add(user1)));
    }
}
