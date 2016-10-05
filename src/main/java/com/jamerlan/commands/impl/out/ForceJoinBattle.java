package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *  FORCEJOINBATTLE userName destinationBattleID [destinationBattlePassword]
 */
public class ForceJoinBattle implements Command{
    private String userName;
    private int destinationBattleID;
    private String destinationBattlePassword;

    public ForceJoinBattle(String userName, int destinationBattleID) {
        this.userName = userName;
        this.destinationBattleID = destinationBattleID;
    }

    public ForceJoinBattle(String userName, int destinationBattleID, String destinationBattlePassword) {
        this.userName = userName;
        this.destinationBattleID = destinationBattleID;
        this.destinationBattlePassword = destinationBattlePassword;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        if (destinationBattlePassword!=null) {
            writer.println("FORCEJOINBATTLE " + userName + " " + destinationBattleID + " " + destinationBattlePassword);
        } else {
            writer.println("FORCEJOINBATTLE " + userName + " " + destinationBattleID);
        }
    }
}
