package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * MUTELIST {mute description}
 MUTELIST Johnny, 345 seconds remaining
 MUTELIST rabbit, indefinite time remaining
 mute description: The form of this argument is not prescribed (it may vary from version to version).
 The lobby client program should simply display it as it receives it.
 */
public class MuteList implements Command<String> {

    private ServerState serverState;

    public MuteList (ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String muteDescription = parser.getString();

        serverState.getChannels().stream().filter(channel -> channel.getChanName().equals(serverState.getCurrentMuteChannel())).findAny()
                .ifPresent(channel -> channel.getMutelist().add(muteDescription));
    }
}
