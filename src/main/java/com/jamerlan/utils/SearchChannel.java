package com.jamerlan.utils;

import com.jamerlan.ServerState;
import com.jamerlan.model.Channel;

import java.util.Iterator;

/**
 * Created by Elt on 21.10.2016.
 */
public class SearchChannel {
    private ServerState serverState;
    private String chanName;

    public Channel byChanName(ServerState serverState, String chanName){
        this.serverState = serverState;
        this.chanName = chanName;
        Channel searchedChannel = null;
        Iterator<Channel> iterator = serverState.getChannels().iterator();
        while (iterator.hasNext()){
            Channel channel = iterator.next();
            if(channel.getChanName()==chanName){
                searchedChannel = channel;
            }
        }
        if (searchedChannel==null){
            Channel newChannel = new Channel(chanName);
            serverState.getChannels().add(newChannel);
            searchedChannel = newChannel;
        }
        return searchedChannel;
    }
}
