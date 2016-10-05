package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 RENAMEACCOUNT newUsername
 */
public class RenameAccount implements Command {
    private String newUserName;
    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("RENAMEACCOUNT " + newUserName);
    }
}
