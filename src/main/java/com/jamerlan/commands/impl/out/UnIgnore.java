package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 UNIGNORE userName=value
 Example:    UNIGNORE userName=joe
 */
public class UnIgnore implements Command<PrintWriter> {
    private String userName;

    public UnIgnore(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("UNIGNORE userName=" + userName);
    }
}
