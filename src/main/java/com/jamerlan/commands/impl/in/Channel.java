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

 похоже один из вариантов решения: есть команда с сервера "ENDOFCHANNELS" которая обязательно идет после всех каналов.
 Другие команды, которые занимают по несколько строк, каждая из которых начинается с имени команды, имеют "*commandname*BEGIN"
 и "*commandname*END" команды, которые соответственно начинают и заканчивают такое списки. Так что наверное надо сделать флаг
 с начала\конца списка команд. И дальше - класс-парсер строк, начинающихся с "\n", который допишет строку к последней переменной
 последней команды.

 */
public class Channel implements Command<String> {

    private ServerState serverState;
    private String topic;
    public Channel(ServerState serverState) {

        this.serverState = serverState;
    }

    @Override
    public void execute(String line) throws IOException {
        CommandParser parser = new CommandParser(line);
        String commandName = parser.getString(" ");

        String chanName = parser.getString(" ");
        int userCount = parser.getInt(" ");

        if (parser.hasNext(" ")){
            topic = parser.getString();
        }


        serverState.getChannels().stream().filter(c->c.getChanName().equals(chanName)).findAny().ifPresent((com.jamerlan.model.Channel c)->{
            c.setUserCount(userCount);
            c.setTopic(topic);

            serverState.getChannels().add(c);
        });
    }
}
