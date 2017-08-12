package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SAYPRIVATEEX userName {message}
 */
public class SayPrivateEx implements Command<PrintWriter> {
    private String userName;
    private String message;

    public SayPrivateEx(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SAYPRIVATEEX " + userName + " " + message);
    }
}
