package com.jamerlan;

import com.jamerlan.commands.impl.JoinBattle;
import com.jamerlan.commands.impl.Login;
import org.junit.Test;

import java.io.IOException;

public class LoginTest {

    @Test
    public void testLogin() throws IOException {
        Login login = new Login("[ru]test", "test", 8888, "*", "java unit test", 0);
        JoinBattle joinBattle = new JoinBattle(19220);

        GameState gameState = new GameState();
        gameState.getConnection();

        login.execute(gameState.getConnection().getWriter());
        joinBattle.execute(gameState.getConnection().getWriter());
        gameState.getConnection().close();
    }
}
