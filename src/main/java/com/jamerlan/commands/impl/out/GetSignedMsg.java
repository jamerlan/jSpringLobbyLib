package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 GETSIGNEDMSG [message_to_sign]
 */
public class GetSignedMsg implements Command {
    private String message;

    public GetSignedMsg(String message) {
        this.message = message;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("GETSIGNEDMSG " + message);
    }
}
