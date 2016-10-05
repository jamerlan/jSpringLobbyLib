package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 MYSTATUS status
 */
public class MyStatus implements Command {
    private Long status;

    public MyStatus(Long status) {
        this.status = status;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("MYSTATUS " + status);
    }
}
