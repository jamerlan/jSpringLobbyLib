package com.jamerlan;

import com.jamerlan.model.Battle;
import com.jamerlan.model.User;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class ServerState implements Serializable {

    private List<Battle> battles = new ArrayList<>();

    public List<User> usersOnline = new ArrayList<>();

    private Connection connection = new Connection();

    public synchronized Connection getConnection() throws IOException {
        if(!connection.isConnected()) {
            connection.connect(GameConstants.HOST, GameConstants.PORT);
            GameProcessor processor = new GameProcessor(this);
            processor.process(connection.getReader());
        }
        return connection;
    }

    public void addUser(String userLine) {
        //ADDUSER [DoR]Isildur[teh] US 0

        String[] userParts = userLine.split(" ");

        String userName = userParts[1];
        String country = userParts[2];
        String accountId = userParts[3];

        User user = new User(userName, country, "-", accountId);
        usersOnline.add(user);
    }

    public List<User> getUsersOnline() {
        return usersOnline;
    }

    public void addOpenedBattle(String openedBattleline){

        String[] openedBattleParts =  openedBattleline.split(" ");

        int battleId = Integer.parseInt(openedBattleParts[1]);
        int type = Integer.parseInt(openedBattleParts[2]);
        int natType = Integer.parseInt(openedBattleParts[3]);
        String fouder = openedBattleParts[4];
        String ip = openedBattleParts[5];
        int port = Integer.parseInt(openedBattleParts[6]);
        int maxPlayers = Integer.parseInt(openedBattleParts[7]);
        int passworded = Integer.parseInt(openedBattleParts[8]);
        int rank = Integer.parseInt(openedBattleParts[9]);
        int mapHash = Integer.parseInt(openedBattleParts[10]);
//        String engineName = openedBattleParts[11];
//        String engineVersion = openedBattleParts[12];
//        String map = openedBattleParts[11];
        String gameName = openedBattleParts[12];
        String title = openedBattleParts[13];
        ArrayList<User> users = new ArrayList<>();
        Battle battle = new Battle(users, battleId, type, natType, fouder, ip, port, maxPlayers, passworded, rank, mapHash);
        battles.add(battle);

    }

    public List<Battle> getBattles() {
        return battles;
    }

    public void addJoinedBattle(String joinedBattleLine){

        String[] joinedBattleParts = joinedBattleLine.split(" ");

        int battleId = Integer.parseInt(joinedBattleParts[1]);
        String userName = joinedBattleParts[2];

        ListIterator<Battle> iterator = battles.listIterator();
        while (iterator.hasNext()){
            Battle battle = iterator.next();

            if(battle.getBattleId()==(battleId)){
                for (User user: usersOnline) {
                    if(userName.equals(user.getUserName())){
                        battle.getUsers().add(user);
                    }
                }
            }
        }
    }

    public void addUpdateBattleInfo(String updateBattleInfoLine){
        String[] updateBattleInfoParts = updateBattleInfoLine.split(" ");

        int battleId = Integer.parseInt(updateBattleInfoParts[1]);
        String spectatorCount = updateBattleInfoParts[2];
        String locked = updateBattleInfoParts[3];
        int mapHash = Integer.parseInt(updateBattleInfoParts[4]);
        String mapName = updateBattleInfoParts[5];

        for (Battle battle:battles){
            if(battle.getBattleId()==(battleId)){
                battle.setMapHash(mapHash);
                battle.setMapName(mapName);
                battle.setLocked(locked);
                battle.setSpectatorCount(spectatorCount);
            }
        }
    }

    public void addLeftBattle(String leftBattleLine){
        String[] leftBattleParts = leftBattleLine.split(" ");

        int battleId = Integer.parseInt(leftBattleParts[1]);
        String userName = leftBattleParts[2];

        ListIterator<Battle> iterator = battles.listIterator();
        while (iterator.hasNext()){
            Battle battle = iterator.next();
            if(battle.getBattleId()==(battleId)){ battle.removeUser(userName); }
        }
    }

    public void searchBattles() {
        System.out.println("------------------+");
        for (Battle battle : battles){
            System.out.println("             serverState.getBattles = " + battle);
        }
        System.out.println("------------------");
    }

}
