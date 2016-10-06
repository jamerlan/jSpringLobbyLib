package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.PrintWriter;

public class MyBattleStatus implements Command{
     private String arg;

     public MyBattleStatus(String arg){
         this.arg = arg;
     }

     @Override
     public void execute(PrintWriter writer){
         writer.println("MYBATTLESTATUS " + arg);
     }
}
