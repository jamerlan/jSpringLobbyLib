package com.jamerlan;

import com.jamerlan.commands.impl.in.*;

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
                            new BattleOpened(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if (lineFromServer.startsWith("UPDATEBATTLEINFO")){
                            new UpdateBattleInfo(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("JOINEDBATTLE")){
                            new JoinedBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CLIENTS")){
                            new Clients(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CHANNELTOPIC")){
                            new ChannelTopic(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("LEFT")){
                            new Left(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("ADDUSER")) {
                            new AddUser(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
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
