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
                    while (((lineFromServer = reader.readLine()) != null)) {
                        if(lineFromServer.startsWith("ACCEPTED")){
                            new Accepted(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("ADDBOT")){
                            new AddBot(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("ADDSTARTRECT")){
                            new AddStartRect(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("ADDUSER")) {
                            new AddUser(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("AGREEMENT")) {
                            new Agreement(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("AGREEMENTEND")) {
                            new AgreementEnd(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("BATTLECLOSED")){
                            new BattleClosed(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if (lineFromServer.startsWith("BATTLEOPENED")){
                            new BattleOpened(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("BROADCAST")) {
                            new Broadcast(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CHANNEL")) {
                            new Channel(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CHANNELMESSAGE")) {
                            new ChannelMessage(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CHANNELTOPIC")){
                            new ChannelTopic(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CLIENTBATTLESTATUS")) {
                            new ClientBattleStatus(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CLIENTIPPORT")) {
                            new ClientIpPort(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CLIENTS ")){
                            new Clients(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if (lineFromServer.startsWith("CLIENTSTATUS")){
                            new ClientStatus(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("COMPFLAGS")) {
                            new CompFlags(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CONNECTUSER")) {
                            new ConnectUser(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("CONNECTUSERFAILED")) {
                            new ConnectUserFailed(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("DENIED")) {
                            new Denied(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("DISABLEUNITS")) {
                            new DisableUnits(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("ENABLEALLUNITS")) {
                            new EnableAllUnits(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("ENABLEUNITS")) {
                            new EnableUnits(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("ENDOFCHANNELS")) {
                            new EndOfChannels(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("FORCEJOINBATTLE")) {
                            new ForceJoinBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("FORCEJOINBATTLEFAILED")) {
                            new ForceJoinBattleFailed(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("FORCELEAVECHANNEL")) {
                            new ForceLeaveChannel(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("FORCEQUITBATTLE")) {
                            new ForceQuitBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("HOSTPORT")) {
                            new HostPort(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("IGNORE")) {
                            new Ignore(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("IGNORELIST")) {
                            new IgnoreList(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("IGNORELISTBEGIN")) {
                            new IgnoreListBegin(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("IGNORELISTEND")) {
                            new IgnoreListEnd(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("JOIN")) {
                            new Join(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("JOINBATTLE")) {
                            new JoinedBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("JOINBATTLEFAILED")) {
                            new JoinBattleFailed(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("JOINBATTLEREQUEST")) {
                            new JoinBattleRequest(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("JOINED")) {
                            new Joined(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("JOINEDBATTLE")) {
                            new JoinedBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("JOINFAILED")) {
                            new JoinFailed(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("LEFT")) {
                            new Left(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("LEFTBATTLE")) {
                            new LeftBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("MOTD")) {
                            new Motd(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("MUTELIST")) {
                            new MuteList(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("MUTELISTBEGIN")) {
                            new MuteListBegin(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("MUTELISTEND")) {
                            new MuteListEnd(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("NOCHANNELTOPIC")) {
                            new NoChannelTopic(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("OPENBATTLE")) {
                            new OpenBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("OPENBATTLEFAILED")) {
                            new OpenBattleFailed(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("PONG")) {
                            new Pong(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("PUBLICKEY")) {
                            new PublicKey(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("REDIRECT")) {
                            new Redirect(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("REGISTRATIONACCEPTED")) {
                            new RegistrationAccepted(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("REGISTRATIONDENIED")) {
                            new RegistrationDenied(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("REMOVEBOT")) {
                            new RemoveBot(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("REMOVESCRIPTTAGS")) {
                            new RemoveScriptTags(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("REMOVESTARTRECT")) {
                            new RemoveStartRect(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("REMOVEUSER")) {
                            new RemoveUser(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("REQUESTBATTLESTATUS")) {
                            new RequestBattleStatus(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("RING")) {
                            new Ring(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAID")) {
                            new Said(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAIDBATTLE")) {
                            new SaidBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAIDBATTLEEX")) {
                            new SaidBattleEx(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAIDDATA")) {
                            new SaidData(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAIDDATABATTLE")) {
                            new SaidDataBattle(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAIDDATAPRIVATE")) {
                            new SaidDataPrivate(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAIDEX")) {
                            new SaidEx(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAIDPRIVATE")) {
                            new SaidPrivate(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAIDPRIVATEEX")) {
                            new SaidPrivateEx(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAYPRIVATE")) {
                            new SayPrivate(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SAYPRIVATEEX")) {
                            new SayPrivateEx(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SERVERMSGBOX")) {
                            new ServerMsgBox(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SETSCRIPTTAGS")) {
                            new SetScriptTags(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SHAREDKEY")) {
                            new SharedKey(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("SIGNEDMSG")) {
                            new SignedMsg(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("TASServer")) {
                            new TASServer(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("TESTLOGINACCEPT")) {
                            new TestLoginAccept(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("TESTLOGINDENY")) {
                            new TestLoginDeny(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("UDPSOURCEPORT")) {
                            new UDPSourcePort(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("UNIGNORE")) {
                            new UnIgnore(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("UPDATEBATTLEINFO")) {
                            new UpdateBattleInfo(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else
                        if(lineFromServer.startsWith("UPDATEBOT")) {
                            new UpdateBot(lineFromServer, serverState).execute(serverState.getConnection().getWriter());
                        }else {
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
