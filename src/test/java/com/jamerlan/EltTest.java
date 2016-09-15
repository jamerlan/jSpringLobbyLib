package com.jamerlan;


import com.jamerlan.commands.impl.JoinBattle;
import com.jamerlan.commands.impl.MyBattleStatus;
import com.jamerlan.utils.Base64Encoder;
import com.jamerlan.utils.MD5Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EltTest {
     static int BattleID = 19220;
        //    https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
        public static void main(String[] args) throws IOException, InterruptedException {
            final String login = "[ru]test";
            final String password = "test";
            final String cpu = "8888";
            final String localIp = "*";
            final String lobbyNameAndVersion = "java test";
            final String userId = "34523452";


            final String host = "78.46.100.157";
            final int port = 8200;

            final String encodedPassword = new Base64Encoder().encodeToString(new MD5Encoder().encode(password));

            final Socket socket = new Socket(host, port);
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    String userInput;
                    try {
                        while ((userInput = in.readLine()) != null) {
                            System.out.println("echo: " + userInput);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(runnable).start();

            Thread.sleep(1000);

            //long b = 000001110100000000000100001000110;
            out.println("LOGIN " + login + " " + encodedPassword + " " + cpu + " " + localIp + " " + lobbyNameAndVersion + " " + userId);
            out.println("CHANNELS");

            JoinBattle joinBattle = new JoinBattle(19220);
            joinBattle.execute(out);

            MyBattleStatus myBattleStatus = new MyBattleStatus("00000001010000000000010011001010");
            myBattleStatus.execute(out);
            //out.println("JOINBATTLE " + BattleID);
            //out.println("MYBATTLESTATUS " + "00000001010000000000010011001110");

            /*Changepassword changepass = new Changepassword();
            if(changepass.outputpas("test", "tesst")){
                System.out.println("Changed");
            }else {
                System.out.println("Not Changed");
            }*/

            //out.println("EXIT");
   }

}
