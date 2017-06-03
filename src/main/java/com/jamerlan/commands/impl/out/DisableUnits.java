package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * DISABLEUNITS unitName1 [unitName2] [...]
 */
public class DisableUnits implements Command{
    private ArrayList<String> units; //must be not null

    public DisableUnits(ArrayList<String> units) {
        this.units = units;
    }

    public ArrayList<String> getUnits() {
        return units;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.print("DISABLEUNITS ");
        for (String unit : units) {
            writer.print(unit + " ");
        }
        writer.println();
    }
}
