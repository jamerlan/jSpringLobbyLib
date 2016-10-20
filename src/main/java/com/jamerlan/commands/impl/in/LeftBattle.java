package com.jamerlan.commands.impl.in;


import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/*LEFTBATTLE battleID userName*/

public class LeftBattle implements Command {
    private String line;
    private ServerState serverState;

    public LeftBattle(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser commandParser = new CommandParser(line);
        String commandName = commandParser.getString(" ");

        String userName = commandParser.getString();

        Iterator<Battle> iterator = serverState.getBattles().iterator();
        while (iterator.hasNext()){
            Battle battle = iterator.next();
            Iterator<User> iteratorUsers = battle.getUsers().iterator();
            while (iteratorUsers.hasNext()) {
                User users = iteratorUsers.next();
                if (users.getUserName().equals(userName)) {
                    iterator.remove();
                }
            }
        }
    }
}
