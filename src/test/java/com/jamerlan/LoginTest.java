package com.jamerlan;

import com.jamerlan.commands.impl.out.JoinBattle;
import com.jamerlan.commands.impl.out.Login;
import org.junit.Test;

import java.io.IOException;

public class LoginTest {

    @Test
    public void testLogin() throws IOException, InterruptedException {
        Login login = new Login("[ru]test", "test", 8888, "*", "java unit test", 0);
        JoinBattle joinBattle = new JoinBattle(19220);

        ServerState serverState = new ServerState();

        login.execute(serverState.getConnection().getWriter());

        joinBattle.execute(serverState.getConnection().getWriter());


        while (true) {
            Thread.sleep(100);
        }

//        serverState.getConnection().close();
    }
}
