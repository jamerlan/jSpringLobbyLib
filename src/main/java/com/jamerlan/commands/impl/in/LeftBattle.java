package com.jamerlan.commands.impl.in;


import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.model.Battle;
import com.jamerlan.model.User;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.stream.Collectors;

/*LEFTBATTLE battleID userName*/

public class LeftBattle implements Command<String> {

    private ServerState serverState;

    public LeftBattle(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser commandParser = new CommandParser(line);
        String commandName = commandParser.getString(" ");

        String userName = commandParser.getString();

        serverState.getBattles().stream().peek(b -> b.getUsers().stream().filter(u -> !(u.getUserName().equals(userName)))).collect(Collectors.toSet());


//        Iterator<Battle> iterator = serverState.getBattles().iterator();
//        while (iterator.hasNext()){
//            Battle battle = iterator.next();
//            Iterator<User> iteratorUsers = battle.getUsers().iterator();
//            while (iteratorUsers.hasNext()) {
//                User users = iteratorUsers.next();
//                if (users.getUserName().equals(userName)) {
//                    iterator.remove();
//                }
//            }
//        }
    }
}
