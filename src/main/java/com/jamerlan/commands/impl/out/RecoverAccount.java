package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 RECOVERACCOUNT email [userName]
 */
public class RecoverAccount implements Command {
    private String email;
    private String userName;

    public RecoverAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;
    }

    public RecoverAccount(String email) {

        this.email = email;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        if(userName!=null){
            writer.println("RECOVERACCOUNT " + email + " " + userName);
        }else{
            writer.println("RECOVERACCOUNT " + email);
        }
    }
}
