package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 FORCETEAMNO userName teamNo
 */
public class ForceTeamNo implements Command<PrintWriter>{
    private String userName;
    private String teamNo;

    public ForceTeamNo(String userName, String teamNo) {
        this.userName = userName;
        this.teamNo = teamNo;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("FORCETEAMNO " + userName + " " + teamNo);
    }
}
