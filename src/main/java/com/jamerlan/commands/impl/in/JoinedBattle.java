package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ListIterator;

/**
 * Created by Elt on 05.10.2016.
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

        ListIterator<Battle> iterator = serverState.getBattles().listIterator();
        while (iterator.hasNext()){
            Battle battle = iterator.next();

            if(battle.getBattleId()==(battleId)){
                for (User user: serverState.getUsersOnline()) {
                    if(userName.equals(user.getUserName())){
                        battle.getUsers().add(user);
                    }
                }
            }
        }
    }
}
