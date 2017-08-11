package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 FORCESPECTATORMODE userName
 */
public class ForceSpectatorMode implements Command<PrintWriter>{
    private String userName;

    public ForceSpectatorMode(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("FORCESPECTATORMODE " + userName);
    }
}
