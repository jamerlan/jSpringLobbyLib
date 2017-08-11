package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 JOIN chanName [key]
 */
public class Join implements Command<PrintWriter> {
    private String chanName;
    private String key;

    public Join(String chanName, String key) {
        this.chanName = chanName;
        this.key = key;
    }

    public Join(String chanName) {

        this.chanName = chanName;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        if(key!=null){
            writer.println("JOIN " + chanName + " " + key);
        }else{
            writer.println("JOIN " + chanName);
        }
    }
}
