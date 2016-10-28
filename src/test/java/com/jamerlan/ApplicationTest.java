package com.jamerlan;

import com.jamerlan.commands.impl.out.*;
import org.junit.Test;

/**
 * Created by Elt on 21.10.2016.
 */
public class ApplicationTest {
    @Test
    public void main() throws Exception {
        ServerState serverState = new ServerState();
        System.out.println(serverState);

        Connection connection = serverState.getConnection();
        System.out.println(connection);

        Login loginCommand = new Login(serverState.getAccount().getLogin(), serverState.getAccount().getPassword(),
                serverState.getAccount().getCpu(), serverState.getAccount().getLocalIp(),
                serverState.getAccount().getLobbyNameAndVersion(), serverState.getAccount().getUserId());
        loginCommand.execute(connection.getWriter());

        Thread.sleep(10000);

        while (true) {
            Ping ping = new Ping();
            ping.execute(connection.getWriter());

            Thread.sleep(2000);
        }
    }
}