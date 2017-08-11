package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOINBATTLEDENY userName [{reason}]
 */
public class JoinBattleDeny implements Command<PrintWriter> {
    private String userName;
    private String reason;

    public JoinBattleDeny(String userName, String reason) {
        this.userName = userName;
        this.reason = reason;
    }

    public JoinBattleDeny(String userName) {

        this.userName = userName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        if(reason!=null){
            writer.println("JOINBATTLEDENY " + userName + " " + reason);
        }else{
            writer.println("JOINBATTLEDENY " + userName);
        }
    }
}
