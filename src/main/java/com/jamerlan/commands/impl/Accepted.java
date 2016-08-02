package com.jamerlan.commands.impl;

import com.jamerlan.Connection;
import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

public class Accepted implements Command {
    private String userName;

    public Accepted(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        System.out.println(userName);
    }
}
