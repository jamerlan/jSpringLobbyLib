package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 FORCELEAVECHANNEL chanName userName [{reason}]
 */
public class ForceLeaveChannel implements Command {
    private String chanName;
    private String userName;
    private String reason;

    public ForceLeaveChannel(String chanName, String userName) {
        this.chanName = chanName;
        this.userName = userName;
    }

    public ForceLeaveChannel(String chanName, String userName, String reason) {
        this.chanName = chanName;
        this.userName = userName;
        this.reason = reason;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        if (reason != null) {
            writer.println("FORCELEAVECHANNEL " + chanName + " " + userName + " " + reason);
        } else {
            writer.println("FORCELEAVECHANNEL " + chanName + " " + userName);
        }
    }
}
