package com.jamerlan.utils;

import com.jamerlan.ServerState;
import com.jamerlan.model.User;

/**
 * Created by Elt on 21.10.2016.
 */
public class SearchUser {
    public User byUserName(ServerState serverState, String userName){
        User searchedUser = null;
        for (User user : serverState.getUsersOnline()) {
            if (user.getUserName().equals(userName)) {
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
