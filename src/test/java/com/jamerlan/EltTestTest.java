package com.jamerlan;

import com.jamerlan.commands.impl.out.JoinBattle;
import com.jamerlan.commands.impl.out.Login;
import com.jamerlan.commands.impl.out.MyBattleStatus;
import com.jamerlan.model.User;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Elt on 24.10.2016.
 */
public class EltTestTest {
    @Test
    public static void main(String[] args) throws IOException, InterruptedException {
        final String login = "[ru]test1";
        final String password = "test1";
        final String cpu = "8888";
        final String localIp = "*";
        final String lobbyNameAndVersion = "java test";
        final String userId = "34523452";

        final String host = "78.46.100.157";
        final int port = 8200;

        ServerState serverState = new ServerState();
        System.out.println(serverState);

        Connection connection = serverState.getConnection();
        System.out.println(connection);

        Login loginCommand = new Login(serverState.getAccount().getLogin(), serverState.getAccount().getPassword(),
                serverState.getAccount().getCpu(), serverState.getAccount().getLocalIp(),
                serverState.getAccount().getLobbyNameAndVersion(), serverState.getAccount().getUserId());
        loginCommand.execute(connection.getWriter());

        JoinBattle joinBattle = new JoinBattle(25258);
        joinBattle.execute(connection.getWriter());

        Thread.sleep(6000);
        MyBattleStatus myBattleStatus = new MyBattleStatus( 10000);
        myBattleStatus.execute(connection.getWriter());

        Thread.sleep(6000);

        serverState.printBattles();
    }
}