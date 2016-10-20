package com.jamerlan;

import com.jamerlan.model.Battle;
import com.jamerlan.model.Channel;
import com.jamerlan.model.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ServerState implements Serializable {

    private String currentMuteChannel;

    private ArrayList<Channel> channels = new ArrayList<>();

    private HashMap<String,String> ignoreList = new HashMap<>();

    private ArrayList<String> unitsBlackList = new ArrayList<>();

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

    public List<String> getUnitsBlackList() {
        return unitsBlackList;
    }

    public HashMap<String,String> getIgnoreList() {
        return ignoreList;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setCurrentMuteChannel(String currentMuteChannel) {
        this.currentMuteChannel = currentMuteChannel;
    }

    public String getCurrentMuteChannel() {
        return currentMuteChannel;
    }

    public void searchBattles() {
        System.out.println("------------------+");
        for (Battle battle : battles){
            System.out.println("             serverState.getBattles = " + battle);
        }
        System.out.println("------------------");
    }
}
