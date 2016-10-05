package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAYDATAPRIVATE userName {message}
 */
public class SayDataPrivate implements Command {
    private String userName;
    private String message;

    public SayDataPrivate(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAYDATAPRIVATE " + userName + " " + message);
    }
}
