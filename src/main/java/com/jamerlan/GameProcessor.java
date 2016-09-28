package com.jamerlan;

import com.jamerlan.commands.impl.in.ClientStatus;
import com.jamerlan.commands.impl.in.LeftBattle;
import com.jamerlan.commands.impl.in.RemoveUser;

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
                String lineFromServer;
                try {
                    while ((lineFromServer = reader.readLine()) != null) {
                        if(lineFromServer.startsWith("REMOVEUSER")){
                            new RemoveUser(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("LEFTBATTLE")){
                            new LeftBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if (lineFromServer.startsWith("CLIENTSTATUS")){
                            new ClientStatus(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if (lineFromServer.startsWith("BATTLEOPENED")){
                            serverState.addOpenedBattle(lineFromServer);
                        }else
                        if (lineFromServer.startsWith("UPDATEBATTLEINFO")){
                            serverState.addUpdateBattleInfo(lineFromServer);
                        }else
                        if(lineFromServer.startsWith("JOINEDBATTLE")){
                            serverState.addJoinedBattle(lineFromServer);
                        }else
                        if(lineFromServer.startsWith("ADDUSER")) {
                            serverState.addUser(lineFromServer);
                        } else {
                            System.out.println("echo: " + lineFromServer);
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
