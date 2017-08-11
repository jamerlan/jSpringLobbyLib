package com.jamerlan.commands.impl.out;


import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

public class JoinBattle implements Command<PrintWriter> {
    private int battleID;

    public JoinBattle(int battleID){
        this.battleID = battleID;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException{
        writer.println("JOINBATTLE " + battleID);
    }
}