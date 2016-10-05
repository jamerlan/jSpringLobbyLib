package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 SETSCRIPTTAGS {pair1} [{pair2}] [{pair3}] [{...}]
 */
public class SetScriptTags implements Command {
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

        for (HashMap.Entry entry : scriptTags.entrySet()) {
            writer.print(" " + entry.getKey() + " " + entry.getValue());
        }
        writer.println();
    }
}
