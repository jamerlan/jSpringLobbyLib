package com.jamerlan;

import com.jamerlan.model.User;

import java.io.BufferedReader;
import java.io.IOException;

public class GameProcessor {
    private final ServerState serverState;

    public GameProcessor(ServerState serverState) {
        this.serverState = serverState;
    }

    public void process(BufferedReader reader) throws IOException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String userInput;
                try {
                    while ((userInput = reader.readLine()) != null) {
                        if(userInput.startsWith("ADDUSER")) {
                            serverState.addUser(userInput);
                        } else {
                            System.out.println("echo: " + userInput);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable).start();
    }
}
