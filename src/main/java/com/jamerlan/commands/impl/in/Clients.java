package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 CLIENTS chanName {clients}
 TODO The server takes the list of clients in a channel, separates it into several lines and sends each line seperately.
 This ensures no line is too long, because the client may have some limit set on the maximum line-length and it could
 ignore the line if it was too long. Also note, that the clients user-name is sent in this list too!
 TODO Channel ?stream?
 */
public class Clients implements Command {
    private String line;
    private ServerState serverState;

    public Clients(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        ArrayList<String> clientsList = new ArrayList<>();
        while(parser.hasNext(" ")){
            clientsList.add(parser.getString(" "));
//            String clients = parser.getString(" ");
        }

        System.out.println(commandName + " " + chanName + " : " + clientsList);
    }
}
