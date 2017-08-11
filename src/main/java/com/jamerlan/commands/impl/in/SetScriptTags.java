package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 SETSCRIPTTAGS {pair1} [{pair2}] [{pair3}] [{...}]
 */
public class SetScriptTags implements Command<String> {

    private ServerState serverState;

    public SetScriptTags(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        ArrayList<String> keys = new ArrayList<>();
        keys.add(parser.getString("\t"));
        while (parser.hasNext("\t")) {
            keys.add(parser.getString("\t"));
        }
    }
}