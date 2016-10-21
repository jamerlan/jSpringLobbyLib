package com.jamerlan;

import com.jamerlan.model.Account;
import com.jamerlan.model.Battle;
import com.jamerlan.model.Channel;
import com.jamerlan.model.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class ServerState implements Serializable {
    Account account = new Account("[ru]test","test", 8888, "*", "java test", 34523452);

    private String currentMuteChannel;

    private ArrayList<Channel> channels = new ArrayList<>();

    private ArrayList<String> unitsBlackList = new ArrayList<>();

    private List<Battle> battles = new ArrayList<>();

    public Set<User> usersOnline = new HashSet<>();

    private Connection connection = new Connection();

    public synchronized Connection getConnection() throws IOException {
        if(!connection.isConnected()) {
            connection.connect(GameConstants.HOST, GameConstants.PORT);
            GameProcessor processor = new GameProcessor(this);
            processor.process(connection.getReader());
        }
        return connection;
    }

    public Set<User> getUsersOnline() {
        return usersOnline;
    }

    public List<Battle> getBattles() {
        return battles;
    }

    public List<String> getUnitsBlackList() {
        return unitsBlackList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public HashMap<String,String> getIgnoreList() {
        return account.getIgnoreList();
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
