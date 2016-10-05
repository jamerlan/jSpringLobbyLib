package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * CHANNELTOPIC chanName {topic}
 */
public class ChannelTopic implements Command{
    private String chanName;
    private String topic;

    public ChannelTopic(String chanName, String topic) {
        this.chanName = chanName;
        this.topic = topic;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("CHANNELTOPIC " + chanName + " " + topic);
    }
}
