package com.jamerlan;

import com.jamerlan.utils.Base64Encoder;
import com.jamerlan.utils.MD5Encoder;

import java.io.*;
import java.net.Socket;

public class BasicTest {

//    https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
    public static void main(String[] args) throws IOException, InterruptedException {
        final String login = "[ru]test";
        final String password = "test";
        final String cpu = "8888";
        final String localIp = "*";
        final String lobbyNameAndVersion = "java test";
        final String userId = "34523452";

        final String host = "192.168.10.102";
//        final String host = "lobby.springrts.com";
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
//                        out.println(userInput);
                        System.out.println("echo: " + in.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable).start();

        Thread.sleep(1000);

        out.println("LOGIN " + login + " " + encodedPassword + " " + cpu + " " + localIp + " " + lobbyNameAndVersion + " " + userId);
        out.println("CHANNELS");

        //CHANNELTOPIC chanName {topic}

        //send !register #test to him as pm
    }
}
