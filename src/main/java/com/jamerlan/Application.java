package com.jamerlan;

import com.jamerlan.commands.impl.out.Login;

import java.io.IOException;

/**
 * http://springrts.com/dl/LobbyProtocol/
 */
public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {

//        final String login = "[ru]test";
//        final String password = "test";
//
//        final int cpu = 8888;
//        final String localIp = "*";
//        final String lobbyNameAndVersion = "java test";
//        final int userId = 34523452;

        ServerState serverState = new ServerState();
        System.out.println(serverState);

        Connection connection = serverState.getConnection();
        System.out.println(connection);

        Login loginCommand = new Login(serverState.getAccount().getLogin(), serverState.getAccount().getPassword(),
                                        serverState.getAccount().getCpu(), serverState.getAccount().getLocalIp(),
                                        serverState.getAccount().getLobbyNameAndVersion(), serverState.getAccount().getUserId());
        loginCommand.execute(connection.getWriter());

        Thread.sleep(10000);
//        serverState.searchBattles();
        while (true) {
            Thread.sleep(100);
        }

    }
}
