package com.jamerlan;

import com.jamerlan.model.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameState implements Serializable {
    private List<User> usersOnline = new ArrayList<>();

    private Connection connection = new Connection();

    public synchronized Connection getConnection() throws IOException {
        if(!connection.isConnected()) {
            connection.connect(GameConstants.HOST, GameConstants.PORT);
            GameProcessor processor = new GameProcessor();
            processor.process(connection.getReader());
        }
        return connection;
    }


    public void exit() {
        if(connection.isConnected()) {
            connection.close();
        }
    }
}
