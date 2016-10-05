package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.PrintWriter;

public class MyBattleStatus implements Command{
     private long arg;

     public MyBattleStatus(long arg){
         this.arg = arg;
     }

     @Override
     public void execute(PrintWriter writer){
         writer.println("MYBATTLESTATUS " + arg);
     }
}
