package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 REMOVESCRIPTTAGS key1 [key2] [key3] [...]
 TODO: add keys?
 */
public class RemoveScriptTags implements Command<String> {

    private ServerState serverState;

    public RemoveScriptTags(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        ArrayList<String> keys = new ArrayList<>();
        keys.add(parser.getString("/t"));
        while(parser.hasNext(" ")){
            keys.add(parser.getString("/t"));
        }

    }
}
