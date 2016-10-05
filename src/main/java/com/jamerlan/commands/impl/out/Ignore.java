package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 IGNORE userName=value [{reason=value}]
 */
public class Ignore implements Command {
    private String userName;
    private String reason;

    public Ignore(String userName) {
        this.userName = userName;
    }

    public Ignore(String userName, String reason) {
        this.userName = userName;
        this.reason = reason;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        if(reason!=null) {
            writer.println("IGNORE " + userName + " " + reason);
        }else{
            writer.println("IGNORE " + userName);
        }
    }
}
