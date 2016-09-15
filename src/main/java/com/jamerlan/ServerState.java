package com.jamerlan;

import com.jamerlan.model.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServerState implements Serializable {
    private List<User> usersOnline = new ArrayList<>();

    private Connection connection = new Connection();

    public synchronized Connection getConnection() throws IOException {
        if(!connection.isConnected()) {
            connection.connect(GameConstants.HOST, GameConstants.PORT);
            GameProcessor processor = new GameProcessor(this);
            processor.process(connection.getReader());
        }
        return connection;
    }

    public void addUser(String userLine) {
        //ADDUSER [DoR]Isildur[teh] US 0

        String[] userParts = userLine.split(" ");

        String userName = userParts[1];
        String country = userParts[2];
        String accountId = userParts[3];

        User user = new User(userName, country, "-", accountId);
        usersOnline.add(user);

        System.out.println("!!!!!!!!!!!!!!!!!! user: " + user);
    }

    public List<User> getUsersOnline() {
        return usersOnline;
    }
}
