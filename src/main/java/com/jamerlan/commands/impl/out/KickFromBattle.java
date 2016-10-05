package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 KICKFROMBATTLE userName
 */
public class KickFromBattle implements Command {
    private String userName;

    public KickFromBattle(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("KICKFROMBATTLE " + userName);
    }
}
