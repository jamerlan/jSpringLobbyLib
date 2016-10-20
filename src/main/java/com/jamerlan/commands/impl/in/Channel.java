package com.jamerlan.commands.impl.in;

import com.jamerlan.ServerState;
import com.jamerlan.commands.Command;
import com.jamerlan.utils.CommandParser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 CHANNEL chanName userCount [{topic}]

 TODO: добавить обработку многострочных топиков

 " echo: CHANNEL Cybernetic 1 ################
 echo: \n################
 echo: \nNext round of PlanetWars there will be only 2 factions, Dynasty of Humanity or Machine Empire. I decided for Cybers to go to Machine Empire, because I don't like Dynasty so much. If someone doesn't feel comfortable with that decission, pm Saktoth that you want to go Dynasty  "
 */
public class Channel implements Command {
    private String line;
    private ServerState serverState;

    public Channel(String line, ServerState serverState) {
        this.line = line;
        this.serverState = serverState;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        String userCount = parser.getString(" ");
        if (parser.hasNext(" ")){
            String topic = parser.getString();
        }else {
            String topic = "";
        }

    }
}
