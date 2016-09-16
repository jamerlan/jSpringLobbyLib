package com.jamerlan;

import com.jamerlan.model.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServerState implements Serializable {
    private List<User> usersOnline = new ArrayList<>();
    private List<OpenedBattle> openedBattles = new ArrayList<>();
    private List<JoinedBattle> joinedBattles = new ArrayList<>();
    private List<UpdateBattleInfo> updateBattleInfos = new ArrayList<>();
    private List<ClientStatus> clientStatuses = new ArrayList<>();
    private List<LeftBattle> leftBattles = new ArrayList<>();

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


        OpenedBattle openedBattle = new OpenedBattle(battleId, type, natType, fouder, ip, port, maxPlayers, passworded, rank, mapHash);
        openedBattles.add(openedBattle);

        //System.out.println("!!!!!!!!!!!!!!!!!! openedBattle: " + openedBattle);
    }

    public List<OpenedBattle> getOpenedBattles() {
        return openedBattles;
    }


    public void addJoinedBattle(String joinedBattleLine){
        String[] joinedBattleParts = joinedBattleLine.split(" ");

        String battleId = joinedBattleParts[1];
        String userName = joinedBattleParts[2];

        JoinedBattle joinedBattle = new JoinedBattle(battleId, userName);
        joinedBattles.add(joinedBattle);

        //System.out.println("!!!!!!!!!!!!!!!!!!  " + joinedBattle);
    }

    public List<JoinedBattle> getJoinedBattles(){ return joinedBattles; }

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

        UpdateBattleInfo updateBattleInfo = new UpdateBattleInfo(battleId, spectatorCount, locked,mapHash,mapName);
        updateBattleInfos.add(updateBattleInfo);

        //System.out.println("!!!!!!!!!!!!!!!!!!  " + updateBattleInfo);
    }

    public List<UpdateBattleInfo> getUpdateBattleInfos(){ return updateBattleInfos; }

    public void addLeftBattle(String leftBattleLine){
        String[] leftBattleParts = leftBattleLine.split(" ");

        String battleId = leftBattleParts[1];
        String userName = leftBattleParts[2];

        LeftBattle leftBattle = new LeftBattle(battleId,userName);
        leftBattles.add(leftBattle);

        System.out.println("!!!!!!!!!!!!!!!!!!  " + leftBattle);
    }

    public List<LeftBattle> getLeftBattles() { return leftBattles; }
}
