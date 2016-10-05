package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAYPRIVATE userName {message}
 */
public class SayPrivate implements Command {
    private String userName;
    private String message;

    public SayPrivate(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAYPRIVATE " + userName + " " + message);
    }
}
