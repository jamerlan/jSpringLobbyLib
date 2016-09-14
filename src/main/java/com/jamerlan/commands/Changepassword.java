package com.jamerlan.commands;

import com.jamerlan.utils.Base64Encoder;
import com.jamerlan.utils.MD5Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Changepassword {

    private static boolean returnvalue;

    public void outputpas(String oldPassword, String newPassword) throws IOException, InterruptedException {
        final String host = "78.46.100.157";
        final int port = 8200;
        final Socket socket = new Socket(host, port);
        final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String userInput;
                try {
                    while (((userInput = in.readLine()) != "SERVERMSG CHANGEPASSWORD failed.")||
                    ((userInput = in.readLine()) != null)){
                        System.out.println("echo: " + in.readLine());
                        Changepassword.returnvalue = true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Changepassword.returnvalue = false;
                }
            }
        };

        new Thread(runnable).start();*/
        final String encodedoldPassword = new Base64Encoder().encodeToString(new MD5Encoder().encode(oldPassword));
        final String encodednewPassword = new Base64Encoder().encodeToString(new MD5Encoder().encode(newPassword));
        out.println("CHANGEACCOUNTPASS " + encodedoldPassword + " " + encodednewPassword);
       // return returnvalue;
    }
}
