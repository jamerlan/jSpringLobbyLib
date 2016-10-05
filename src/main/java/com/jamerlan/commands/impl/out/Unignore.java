package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 UNIGNORE userName=value
 Example:    UNIGNORE userName=joe
 */
public class Unignore implements Command {
    private String userName;

    public Unignore(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("UNIGNORE userName=" + userName);
    }
}
