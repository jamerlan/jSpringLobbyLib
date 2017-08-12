package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * GETPUBLICKEY
 */
public class GetPublicKey implements Command<PrintWriter> {
    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("GETPUBLICKEY");
    }
}
