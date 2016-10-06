package com.jamerlan.commands.impl.in;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 ADDSTARTRECT allyNo left top right bottom
 */
public class AddStartRect implements Command {
    private int allyNo;
    private String left;
    private String top;
    private String right;
    private String bottom;

    @Override
    public void execute(PrintWriter writer) throws IOException {

    }
}
