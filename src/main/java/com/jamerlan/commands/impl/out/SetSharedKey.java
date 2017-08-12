package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 SETSHAREDKEY [session_key]
 */
public class SetSharedKey implements Command<PrintWriter> {
    private String sessionKey;

    public SetSharedKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("SETSHAREDKEY " + sessionKey);
    }
}
