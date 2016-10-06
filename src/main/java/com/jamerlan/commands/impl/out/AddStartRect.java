package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ADDSTARTRECT allyNo left top right bottom
 * TODO left top right bottom have coordinates?
 */
public class AddStartRect implements Command{
    private int allyNo;
    private String left;
    private String top;
    private String right;
    private String bottom;

    public AddStartRect(int allyNo, String left, String top, String right, String bottom) {
        this.allyNo = allyNo;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("ADDSTARTRECT " + allyNo + " " + left + " " + top + " " + right + " " + bottom);
    }
}
