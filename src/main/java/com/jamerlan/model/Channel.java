package com.jamerlan.model;

import java.util.ArrayList;

public class Channel {
    private String chanName;
    private int userCount;

    private String topicAuthor;
    private String topicChangedTime;
    private String topic;

    private ArrayList<String> mutelist;
    private ArrayList<String> clients;

    public Channel(String chanName, int userCount, String topic) {
        this.chanName = chanName;
        this.userCount = userCount;
        this.topic = topic;
    }

    public Channel(String chanName) {
        this.chanName = chanName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Channel channel = (Channel) o;

        return chanName.equals(channel.chanName);
    }

    @Override
    public int hashCode() {
        return chanName.hashCode();
    }

    @Override
    public String toString() {
        return "Channel{" +
                "chanName='" + chanName + '\'' +
                ", userCount=" + userCount +
                ", topicAuthor='" + topicAuthor + '\'' +
                ", topicChangedTime='" + topicChangedTime + '\'' +
                ", topic='" + topic + '\'' +
                ", mutelist=" + mutelist +
                ", clients=" + clients +
                '}';
    }

    public String getTopicAuthor() {
        return topicAuthor;
    }

    public void setTopicAuthor(String topicAuthor) {
        this.topicAuthor = topicAuthor;
    }

    public String getTopicChangedTime() {
        return topicChangedTime;
    }

    public void setTopicChangedTime(String topicChangedTime) {
        this.topicChangedTime = topicChangedTime;
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

    public ArrayList<String> getClients() {
        return clients;
    }

    public void setClients(ArrayList<String> clients) {
        this.clients = clients;
    }
}
