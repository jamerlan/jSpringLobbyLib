package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;
import com.jamerlan.utils.Base64Encoder;
import com.jamerlan.utils.MD5Encoder;

import java.io.IOException;
import java.io.PrintWriter;

//LOGIN userName password cpu localIP {lobby name and version} [userID] [{compFlags}]
public class Login implements Command<PrintWriter> {

    private final String login;
    private final String password;
    private final int cpu;
    private final String localIp;
    private final String lobbyNameAndVersion;
    private final int userId;

    public Login(String login, String password, int cpu, String localIp, String lobbyNameAndVersion, int userId) {
        this.login = login;
        this.password = password;
        this.cpu = cpu;
        this.localIp = localIp;
        this.lobbyNameAndVersion = lobbyNameAndVersion;
        this.userId = userId;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        String encodedPassword = new Base64Encoder().encodeToString(new MD5Encoder().encode(password));
        writer.println("LOGIN " + login + " " + encodedPassword + " " + cpu + " " + localIp + " " + lobbyNameAndVersion + " " + userId);
    }
}
