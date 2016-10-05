package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Elt on 05.10.2016.
 */
public class EnableAllUnits implements Command {
    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.println("ENABLEALLUNITS");
    }
}
