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

    private Set<Channel> channels = new HashSet<>();

    private List<String> unitsBlackList = new ArrayList<>();

    private Set<Battle> battles = new HashSet<>();

    private Battle hostedBattle;

    private Set<User> usersOnline = new HashSet<>();

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

    public Set<Battle> getBattles() {
        return battles;
    }

    public Set<Channel> getChannels() {
        return channels;
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

    public void setCurrentMuteChannel(String currentMuteChannel) {
        this.currentMuteChannel = currentMuteChannel;
    }

    public String getCurrentMuteChannel() {
        return currentMuteChannel;
    }

    public Battle getHostedBattle() {
        return hostedBattle;
    }

    public void setHostedBattle(Battle hostedBattle) {
        this.hostedBattle = hostedBattle;
    }

    public void searchBattles() {
        System.out.println("------------------+");
        for (Battle battle : battles){
            System.out.println(battle.getUsers() + "             " + battle);
        }
        System.out.println("------------------");
    }public void searchUsers() {
        System.out.println("------------------+");
        for (User user : usersOnline){
            System.out.println("             " + user);
        }
        System.out.println("------------------");
    }public void searchChannels() {
        System.out.println("------------------+");
        for (Channel channel : channels){
            System.out.println("             Channels = " + channel);
        }
        System.out.println("------------------");
    }
}
