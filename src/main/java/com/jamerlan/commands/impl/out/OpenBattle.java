package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 OPENBATTLE type natType password port maxPlayers gameHash rank mapHash {engineName} {engineVersion} {map} {title} {gameName}
 */
public class OpenBattle implements Command {
    private int type;
    private int natType;
    private String password;
    private int port;
    private int maxPlayers;
    private int gameHash;
    private int rank;
    private int mapHash;
    private String map;
    private String title;
    private String gameName;

    public OpenBattle(int type, int natType, String password, int port, int maxPlayers, int gameHash, int rank, int mapHash, String map, String title, String gameName) {
        this.type = type;
        this.natType = natType;
        this.password = password;
        this.port = port;
        this.maxPlayers = maxPlayers;
        this.gameHash = gameHash;
        this.rank = rank;
        this.mapHash = mapHash;
        this.map = map;
        this.title = title;
        this.gameName = gameName;
    }

    public OpenBattle(int type, int natType, String password, int port, int maxPlayers, int gameHash, int rank, int mapHash, String map, String title) {

        this.type = type;
        this.natType = natType;
        this.password = password;
        this.port = port;
        this.maxPlayers = maxPlayers;
        this.gameHash = gameHash;
        this.rank = rank;
        this.mapHash = mapHash;
        this.map = map;
        this.title = title;
    }

    public OpenBattle(int type, int natType, String password, int port, int maxPlayers, int gameHash, int rank, int mapHash, String map) {

        this.type = type;
        this.natType = natType;
        this.password = password;
        this.port = port;
        this.maxPlayers = maxPlayers;
        this.gameHash = gameHash;
        this.rank = rank;
        this.mapHash = mapHash;
        this.map = map;
    }

    public OpenBattle(int type, int natType, String password, int port, int maxPlayers, int gameHash, int rank, int mapHash) {

        this.type = type;
        this.natType = natType;
        this.password = password;
        this.port = port;
        this.maxPlayers = maxPlayers;
        this.gameHash = gameHash;
        this.rank = rank;
        this.mapHash = mapHash;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        if((map!=null)&&(title!=null)&&(gameName!=null)){
            writer.println("OPENBATTLE " + type + " " + natType + " " + password + " " + port + " " + maxPlayers + " " + gameHash + " " + rank + " " + mapHash + " " + map + " " + title + " " + gameName);
        }else
            if((map!=null)&&(title!=null)){
                writer.println("OPENBATTLE " + type + " " + natType + " " + password + " " + port + " " + maxPlayers + " " + gameHash + " " + rank + " " + mapHash + " " + map + " " + title);
            }else
                if((map!=null)){
                    writer.println("OPENBATTLE " + type + " " + natType + " " + password + " " + port + " " + maxPlayers + " " + gameHash + " " + rank + " " + mapHash + " " + map);
                }else{
                    writer.println("OPENBATTLE " + type + " " + natType + " " + password + " " + port + " " + maxPlayers + " " + gameHash + " " + rank + " " + mapHash);
                }
    }
}
