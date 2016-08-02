package com.jamerlan;

import com.jamerlan.commands.impl.Login;
import org.junit.Test;

import java.io.IOException;

public class LoginTest {

    @Test
    public void testLogin() throws IOException {
        Login login = new Login("LOGIN", "PASSWORD", 8888, "*", "java unit test", 0);

        GameState gameState = new GameState();
        gameState.getConnection();

        login.execute(gameState.getConnection().getWriter());

        gameState.getConnection().close();
    }
}
