package com.jamerlan;

import java.io.*;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private boolean connected = false;

    public void connect(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        connected = true;
    }

    public PrintWriter getWriter() {
        return out;
    }

    public BufferedReader getReader() {
        return in;
    }

    public void close() {
//        try {
//            socket.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        out.close();
    }

    public boolean isConnected() {
        return connected;
    }
}
