package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * MUTELIST {mute description}
 MUTELIST Johnny, 345 seconds remaining
 MUTELIST rabbit, indefinite time remaining
 mute description: The form of this argument is not prescribed (it may vary from version to version).
 The lobby client program should simply display it as it receives it.
 */
public class MuteList implements Command {
    private String line;
    private ServerState serverState;

    public MuteList (String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String userName = parser.getString(" ");
        if (parser.hasNext("")){
            String description = parser.getString();
            System.out.println(commandName = " " + userName + " " + description);
        }else{
            System.out.println(commandName = " " + userName);
        }
    }
}
