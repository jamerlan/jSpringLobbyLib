package com.jamerlan;

import com.jamerlan.commands.impl.out.Login;
import com.jamerlan.commands.impl.out.OpenBattle;
import com.jamerlan.commands.impl.out.Ping;
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
        OpenBattle openBattle = new OpenBattle(0,0,"",8080, 32, 0, 0, 0, "Red Comet");
        openBattle.execute(connection.getWriter());
        Thread.sleep(4000);
        serverState.searchBattles();
        while (true) {
            Ping ping = new Ping();
            ping.execute(connection.getWriter());

            Thread.sleep(2000);
        }
    }
}