package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 REMOVESCRIPTTAGS key1 [key2] [key3] [...]
 */
public class RemoveScriptTags implements Command {
    private ArrayList<String> keys;

    public RemoveScriptTags(ArrayList<String> keys) {
        this.keys = keys;
    }

    public ArrayList<String> getKeys() {
        return keys;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.print("REMOVESCRIPTTAGS ");
        for (Object key : keys) {
            writer.print(key + " ");
        }
        writer.println();
    }
}
