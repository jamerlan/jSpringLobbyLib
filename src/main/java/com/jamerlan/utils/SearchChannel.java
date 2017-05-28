package com.jamerlan.utils;

import com.jamerlan.ServerState;
import com.jamerlan.model.Channel;

import java.util.Iterator;

/**
 * Created by Elt on 21.10.2016.
 */
public class SearchChannel {
    public Channel byChanName(ServerState serverState, String chanName){
        Channel searchedChannel = null;
        for (Channel channel : serverState.getChannels()) {
            if (channel.getChanName().equals(chanName)) {
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
