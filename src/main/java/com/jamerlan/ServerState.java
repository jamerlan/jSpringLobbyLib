package com.jamerlan;

import com.jamerlan.model.Battle;
import com.jamerlan.model.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ServerState implements Serializable {

    private List<Battle> battles = new ArrayList<>();

    public List<User> usersOnline = new ArrayList<>();

    private Connection connection = new Connection();

    public synchronized Connection getConnection() throws IOException {
        if(!connection.isConnected()) {
            connection.connect(GameConstants.HOST, GameConstants.PORT);
            GameProcessor processor = new GameProcessor(this);
            processor.process(connection.getReader());
        }
        return connection;
    }

    public List<User> getUsersOnline() {
        return usersOnline;
    }

    public List<Battle> getBattles() {
        return battles;
    }

    public void searchBattles() {
        System.out.println("------------------+");
        for (Battle battle : battles){
            System.out.println("             serverState.getBattles = " + battle);
        }
        System.out.println("------------------");
    }
}
