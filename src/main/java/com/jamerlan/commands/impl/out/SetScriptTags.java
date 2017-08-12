package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 SETSCRIPTTAGS {pair1} [{pair2}] [{pair3}] [{...}]
 */
public class SetScriptTags implements Command<PrintWriter> {
    private HashMap<String,Integer> scriptTags;

    public HashMap<String, Integer> getScriptTags() {
        return scriptTags;
    }

    public SetScriptTags(HashMap<String, Integer> scriptTags) {

        this.scriptTags = scriptTags;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        writer.print("SETSCRIPTTAGS");

        scriptTags.entrySet().forEach(entry->    writer.print(" " + entry.getKey() + " " + entry.getValue()));
        writer.println();
    }
}
