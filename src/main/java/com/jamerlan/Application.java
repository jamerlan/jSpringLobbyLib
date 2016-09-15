package com.jamerlan;

import com.jamerlan.commands.impl.Login;

import java.io.IOException;

/**
 * http://springrts.com/dl/LobbyProtocol/
 */
public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String login = "[ru]test";
        final String password = "test";

        final int cpu = 8888;
        final String localIp = "*";
        final String lobbyNameAndVersion = "java test";
        final int userId = 34523452;

        ServerState serverState = new ServerState();
        System.out.println(serverState);

        Connection connection = serverState.getConnection();
        System.out.println(connection);

        Login loginCommand = new Login(login, password, cpu, localIp, lobbyNameAndVersion, userId);
        loginCommand.execute(connection.getWriter());

        while (true) {
            Thread.sleep(100);
        }
    }
}
