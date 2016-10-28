package com.jamerlan.utils;

import com.jamerlan.ServerState;
import com.jamerlan.model.User;

import java.util.Iterator;

/**
 * Created by Elt on 21.10.2016.
 */
public class SearchUser {
    private ServerState serverState;
    private String userName;

    public User byUserName(ServerState serverState, String userName){
        this.serverState = serverState;
        this.userName = userName;
        User searchedUser = null;
        Iterator<User> iterator = serverState.getUsersOnline().iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getUserName().equals(userName)){
                searchedUser = user;
            }
        }
        if (searchedUser==null){
                User newUser = new User(userName);
                serverState.getUsersOnline().add(newUser);
                searchedUser = newUser;
        }
        return searchedUser;
    }
}
