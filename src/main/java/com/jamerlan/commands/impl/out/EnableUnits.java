package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * ENABLEUNITS unitName1 [unitName2] [...]
 */
public class EnableUnits implements Command{
    private ArrayList<String> units; //must be not null

    public EnableUnits(ArrayList<String> units) {
        this.units = units;
    }

    public ArrayList<String> getUnits() {
        return units;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.print("ENABLEUNITS ");
        Iterator<String> iterator = units.iterator();
        while(iterator.hasNext()){
            writer.print(iterator.next() + " ");
        }
        writer.println();
    }
}
