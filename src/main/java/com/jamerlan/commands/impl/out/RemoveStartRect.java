package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 REMOVESTARTRECT allyNo
 */
public class RemoveStartRect implements Command<PrintWriter> {
    private String allyNo;

    public RemoveStartRect(String allyNo) {
        this.allyNo = allyNo;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("REMOVESTARTRECT " + allyNo);
    }
}
