package com.jamerlan;

import com.jamerlan.commands.impl.in.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

public class GameProcessor {
    private final ServerState serverState;

    public GameProcessor(ServerState serverState) {
        this.serverState = serverState;
    }

    public void process(BufferedReader reader) throws IOException {
        Runnable runnable = () -> {
            String lineFromServer;
            try {
                while (((lineFromServer = reader.readLine()) != null)) {
                    if(lineFromServer.startsWith("ACCEPTED ")){
                        new Accepted(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("ADDBOT ")){
                        new AddBot(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("ADDSTARTRECT ")){
                        new AddStartRect(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("ADDUSER ")) {
                        new AddUser(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("AGREEMENT ")) {
                        new Agreement(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("AGREEMENTEND ")) {
                        new AgreementEnd(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("BATTLECLOSED ")){
                        new BattleClosed(serverState).execute(lineFromServer);
                    }else if (lineFromServer.startsWith("BATTLEOPENED ")){
                        new BattleOpened(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("BROADCAST ")) {
                        new Broadcast(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("CHANNEL ")) {
                        new Channel(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("CHANNELMESSAGE ")) {
                        new ChannelMessage(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("CHANNELTOPIC ")){
                        new ChannelTopic(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("CLIENTBATTLESTATUS ")) {
                        new ClientBattleStatus(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("CLIENTIPPORT ")) {
                        new ClientIpPort(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("CLIENTS ")){
                        new Clients(serverState).execute(lineFromServer);
                    }else if (lineFromServer.startsWith("CLIENTSTATUS ")){
                        new ClientStatus(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("COMPFLAGS ")) {
                        new CompFlags(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("CONNECTUSER ")) {
                        new ConnectUser(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("CONNECTUSERFAILED ")) {
                        new ConnectUserFailed(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("DENIED ")) {
                        new Denied(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("DISABLEUNITS ")) {
                        new DisableUnits(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("ENABLEALLUNITS ")) {
                        new EnableAllUnits(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("ENABLEUNITS ")) {
                        new EnableUnits(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("ENDOFCHANNELS")) {
                        new EndOfChannels(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("FORCEJOINBATTLE ")) {
                        new ForceJoinBattle(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("FORCEJOINBATTLEFAILED ")) {
                        new ForceJoinBattleFailed(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("FORCELEAVECHANNEL ")) {
                        new ForceLeaveChannel(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("FORCEQUITBATTLE ")) {
                        new ForceQuitBattle(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("HOSTPORT ")) {
                        new HostPort(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("IGNORE ")) {
                        new Ignore(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("IGNORELIST ")) {
                        new IgnoreList(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("IGNORELISTBEGIN")) {
                        new IgnoreListBegin(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("IGNORELISTEND")) {
                        new IgnoreListEnd(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("JOIN ")) {
                        new Join(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("JOINBATTLE ")) {
                        new JoinBattle(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("JOINBATTLEFAILED ")) {
                        new JoinBattleFailed(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("JOINBATTLEREQUEST ")) {
                        new JoinBattleRequest(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("JOINED ")) {
                        new Joined(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("JOINEDBATTLE ")) {
                        new JoinedBattle(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("JOINFAILED ")) {
                        new JoinFailed(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("LEFT ")) {
                        new Left(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("LEFTBATTLE ")) {
                        new LeftBattle(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("LOGININFOEND")) {
                        new LoginInfoEnd(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("MOTD ")) {
                        new Motd(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("MUTELIST ")) {
                        new MuteList(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("MUTELISTBEGIN ")) {
                        new MuteListBegin(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("MUTELISTEND ")) {
                        new MuteListEnd(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("NOCHANNELTOPIC ")) {
                        new NoChannelTopic(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("OPENBATTLE ")) {
                        new OpenBattle(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("OPENBATTLEFAILED ")) {
                        new OpenBattleFailed(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("PONG")) {
                        new Pong(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("PUBLICKEY ")) {
                        new PublicKey(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("REDIRECT ")) {
                        new Redirect(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("REGISTRATIONACCEPTED ")) {
                        new RegistrationAccepted(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("REGISTRATIONDENIED ")) {
                        new RegistrationDenied(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("REMOVEBOT ")) {
                        new RemoveBot(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("REMOVESCRIPTTAGS ")) {
                        new RemoveScriptTags(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("REMOVESTARTRECT ")) {
                        new RemoveStartRect(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("REMOVEUSER ")) {
                        new RemoveUser(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("REQUESTBATTLESTATUS")) {
                        new RequestBattleStatus(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("RING ")) {
                        new Ring(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAID ")) {
                        new Said(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAIDBATTLE ")) {
                        new SaidBattle(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAIDBATTLEEX ")) {
                        new SaidBattleEx(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAIDDATA ")) {
                        new SaidData(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAIDDATABATTLE ")) {
                        new SaidDataBattle(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAIDDATAPRIVATE ")) {
                        new SaidDataPrivate(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAIDEX ")) {
                        new SaidEx(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAIDPRIVATE ")) {
                        new SaidPrivate(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAIDPRIVATEEX ")) {
                        new SaidPrivateEx(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAYPRIVATE ")) {
                        new SayPrivate(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SAYPRIVATEEX ")) {
                        new SayPrivateEx(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SERVERMSG ")) {
                        new ServerMsg(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SERVERMSGBOX ")) {
                        new ServerMsgBox(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SETSCRIPTTAGS ")) {
                        new SetScriptTags(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SHAREDKEY ")) {
                        new SharedKey(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("SIGNEDMSG ")) {
                        new SignedMsg(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("TASServer ")) {
                        new TASServer(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("TESTLOGINACCEPT")) {
                        new TestLoginAccept(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("TESTLOGINDENY")) {
                        new TestLoginDeny(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("UDPSOURCEPORT ")) {
                        new UDPSourcePort(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("UNIGNORE ")) {
                        new UnIgnore(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("UPDATEBATTLEINFO ")) {
                        new UpdateBattleInfo(serverState).execute(lineFromServer);
                    }else if(lineFromServer.startsWith("UPDATEBOT ")) {
                        new UpdateBot(serverState).execute(lineFromServer);
                    }else {
                        System.out.println("echo: " + lineFromServer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(runnable).start();
    }
}
