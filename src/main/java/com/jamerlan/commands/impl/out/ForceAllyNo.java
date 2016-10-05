package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 FORCEALLYNO userName teamNo
 */
public class ForceAllyNo implements Command{
    private String userName;
    private int teamNo;

    public ForceAllyNo(String userName, int teamNo) {
        this.userName = userName;
        this.teamNo = teamNo;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("FORCEALLYNO " + userName + " " + teamNo);
    }
}
