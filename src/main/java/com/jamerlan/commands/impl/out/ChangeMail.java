package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * CHANGEEMAIL newEmail [userName]
 */
public class ChangeMail implements Command{
    private String newEmail;
    private String userName;

    public ChangeMail(String newEmail, String userName) {
        this.newEmail = newEmail;
        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("CHANGEACCOUNTPASS " + newEmail + " " + userName);

    }
}
