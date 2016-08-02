package com.jamerlan;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GameState gameState = new GameState();
        System.out.println(gameState);
        Connection connection = gameState.getConnection();
        System.out.println(connection);
    }
}
