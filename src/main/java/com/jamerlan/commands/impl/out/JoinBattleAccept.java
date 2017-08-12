package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOINBATTLEACCEPT userName
 */
public class JoinBattleAccept implements Command<PrintWriter> {
    private String userName;

    public JoinBattleAccept(String userName) {
        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("JOINBATTLEACCEPT " + userName);
    }
}
