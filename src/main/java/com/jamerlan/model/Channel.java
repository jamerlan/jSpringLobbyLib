package com.jamerlan.model;

import java.util.ArrayList;

/**
 * Created by Elt on 20.10.2016.
 */

public class Channel {
    private String chanName;
    private int userCount;
    private String topic;
    private ArrayList<String> mutelist;
    private ArrayList<User> clients;

    public Channel(String chanName, int userCount, String topic) {
        this.chanName = chanName;
        this.userCount = userCount;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "chanName='" + chanName + '\'' +
                ", userCount=" + userCount +
                ", topic='" + topic + '\'' +
                ", mutelist=" + mutelist +
                ", clients=" + clients +
                '}';
    }

    public String getChanName() {
        return chanName;
    }

    public void setChanName(String chanName) {
        this.chanName = chanName;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ArrayList<String> getMutelist() {
        return mutelist;
    }

    public void setMutelist(ArrayList<String> mutelist) {
        this.mutelist = mutelist;
    }

    public ArrayList<User> getClients() {
        return clients;
    }

    public void setClients(ArrayList<User> clients) {
        this.clients = clients;
    }
}
