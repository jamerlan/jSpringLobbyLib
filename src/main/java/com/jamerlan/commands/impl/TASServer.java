package com.jamerlan.commands.impl;

import com.jamerlan.Connection;
import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

//TASSERVER protocolVersion springVersion udpPort serverMode
//TASServer 0.36 96.0 8201 0
public class TASServer implements Command {

    private final String protocolVersion;
    private final String springVersion;
    private final String udpPort;
    private final String serverMode;

    public TASServer(String protocolVersion, String springVersion, String udpPort, String serverMode) {
        this.protocolVersion = protocolVersion;
        this.springVersion = springVersion;
        this.udpPort = udpPort;
        this.serverMode = serverMode;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {

    }
}
