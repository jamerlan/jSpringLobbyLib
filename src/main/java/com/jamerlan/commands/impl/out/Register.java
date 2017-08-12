package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * REGISTER userName password [email]
 */
public class Register implements Command<PrintWriter>{
    private String userName;
    private String passwond;
    private String email;

    public Register(String userName, String passwond, String email) {
        this.userName = userName;
        this.passwond = passwond;
        this.email = email;
    }

    public Register(String userName, String passwond) {

        this.userName = userName;
        this.passwond = passwond;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        if (email!=null){
            writer.println("REGISTER " + userName + " " + passwond + " " + email);
        }else{
            writer.println("REGISTER " + userName + " " + passwond);
        }

    }
}
