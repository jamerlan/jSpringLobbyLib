package com.jamerlan;

import com.jamerlan.model.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ServerState implements Serializable {

    private List<Battle> battles = new ArrayList<>();

    private List<User> usersOnline = new ArrayList<>();
//    private List<OpenedBattle> openedBattles = new ArrayList<>();
//    private List<JoinedBattle> joinedBattles = new ArrayList<>();
    private List<ClientStatus> clientStatuses = new ArrayList<>();
//    private List<LeftBattle> leftBattles = new ArrayList<>();

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

//        System.out.println("!!!!!!!!!!!!!!!!!! user: " + user);
    }

    public List<User> getUsersOnline() {
        return usersOnline;
    }

    public void addOpenedBattle(String openedBattleline){

        String[] openedBattleParts =  openedBattleline.split(" ");

        String battleId = openedBattleParts[1];
        String type = openedBattleParts[2];
        String natType = openedBattleParts[3];
        String fouder = openedBattleParts[4];
        String ip = openedBattleParts[5];
        String port = openedBattleParts[6];
        String maxPlayers = openedBattleParts[7];
        String passworded = openedBattleParts[8];
        String rank = openedBattleParts[9];
        String mapHash = openedBattleParts[10];
//        String engineName = openedBattleParts[11];
//        String engineVersion = openedBattleParts[12];
//        String map = openedBattleParts[11];
//        String gameName = openedBattleParts[12];
//        String title = openedBattleParts[13];
        ArrayList<String> users = new ArrayList<>();
        Battle battle = new Battle(users, battleId, type, natType, fouder, ip, port, maxPlayers, passworded, rank, mapHash);
        battles.add(battle);

    }

    public List<Battle> getBattles() {
        for (int i = 0; i < battles.size(); i++){
            System.out.println("      " + battles.toString());
        }

        return battles;
    }

    public void addJoinedBattle(String joinedBattleLine){

        String[] joinedBattleParts = joinedBattleLine.split(" ");

        String battleId = joinedBattleParts[1];
        String userName = joinedBattleParts[2];

        ListIterator<Battle> iterator = battles.listIterator();
        while (iterator.hasNext()){
            Battle seekingbattle = iterator.next();
            if(seekingbattle.getBattleId().equals(battleId)){ seekingbattle.addUser(userName); }
        }
    }

//    public List<JoinedBattle> getJoinedBattles(){ return joinedBattles; }

    public void addClientStatus(String clientStatusLine){
        String[] clientStatusParts = clientStatusLine.split(" ");

        String userName = clientStatusParts[1];
        String status = clientStatusParts[2];

        ClientStatus clientStatus = new ClientStatus(userName,status);
        clientStatuses.add(clientStatus);

        //System.out.println("!!!!!!!!!!!!!!!!!!  " + clientStatus);
    }

    public List<ClientStatus> getClientStatuses(){ return clientStatuses; }

    public void addUpdateBattleInfo(String updateBattleInfoLine){
        String[] updateBattleInfoParts = updateBattleInfoLine.split(" ");

        String battleId = updateBattleInfoParts[1];
        String spectatorCount = updateBattleInfoParts[2];
        String locked = updateBattleInfoParts[3];
        String mapHash = updateBattleInfoParts[4];
        String mapName = updateBattleInfoParts[5];

        for (Battle seekingBattle:battles){
            if(seekingBattle.getBattleId().equals(battleId)){
                seekingBattle.setMapHash(mapHash);
                seekingBattle.setMapName(mapName);
                seekingBattle.setLocked(locked);
                seekingBattle.setSpectatorCount(spectatorCount);
            }
        }
    }

    public void addLeftBattle(String leftBattleLine){
        String[] leftBattleParts = leftBattleLine.split(" ");

        String battleId = leftBattleParts[1];
        String userName = leftBattleParts[2];

        LeftBattle leftBattle = new LeftBattle(battleId,userName);
        ListIterator<Battle> iterator = battles.listIterator();
        while (iterator.hasNext()){
            Battle seekingbattle = iterator.next();
            if(seekingbattle.getBattleId().equals(battleId)){ seekingbattle.removeUser(userName); }
        }
    }

//    public List<LeftBattle> getLeftBattles() { return leftBattles; }

    public void removeUser(String removeUserLine){
        String[] removeUserParts = removeUserLine.split(" ");

        String userName = removeUserParts[1];

        Iterator<User> iterator = usersOnline.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getUserName().equals(userName)){
                iterator.next();
                iterator.remove();
            }
        }

    }

    public void searchBattles(){
        System.out.println("------------------+");
        for (Battle battle:battles){
            System.out.println("             serverState.getBattles = " + battle);
        }
        System.out.println("------------------");
    }

}
