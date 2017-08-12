package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;
import com.jamerlan.model.Channel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 CHANNELTOPIC chanName author changedTime {topic}
 */
public class ChannelTopic implements Command<String> {

    private ServerState serverState;

    public ChannelTopic(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        System.out.println("                                        Topic Command Established!");
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        String author = parser.getString(" ");
        String changedTime = parser.getString(" ");
        String topic = parser.getString();

        System.out.println("            Topic: " + topic);

        serverState.getChannels().stream().filter(c-> c.getChanName().equals(chanName)).findAny().ifPresent((Channel c)->{
            c.setTopicAuthor(author);
            c.setTopicChangedTime(changedTime);
            c.setTopic(topic);
        });
    }
}
