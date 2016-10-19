package com.jamerlan;


import com.jamerlan.commands.impl.out.JoinBattle;
import com.jamerlan.utils.Base64Encoder;
import com.jamerlan.utils.MD5Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EltTest {
     static int BattleID = 21414;
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

            long b = 16777215;
            out.println("LOGIN " + login + " " + encodedPassword + " " + cpu + " " + localIp + " " + lobbyNameAndVersion + " " + userId);
            out.println("CHANNELS");

            JoinBattle joinBattle = new JoinBattle(23853);
            joinBattle.execute(out);
            Thread.sleep(3000);
            out.println("MYBATTLESTATUS " + b);
                   // "00000001010000000000010011001110");
//            MyBattleStatus myBattleStatus = new MyBattleStatus("00110111001101001000101010011001");
//            myBattleStatus.execute(out);
            Thread.sleep(2000);
//
//            AddBot addBot = new AddBot("Vuasya", "00001111110000000000011111001110", "00BBGGRR");
//            addBot.execute(out);
//            while (true) {
//                Thread.sleep(100);
//            }

//            out.println("JOINBATTLE " + BattleID);
//            out.println("MYBATTLESTATUS " + "00000001010000000000010011001110");

            /*Changepassword changepass = new Changepassword();
            if(changepass.outputpas("test", "tesst")){
                System.out.println("Changed");
            }else {
                System.out.println("Not Changed");
            }*/

            //out.println("EXIT");
   }

}
