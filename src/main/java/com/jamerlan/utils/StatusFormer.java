package com.jamerlan.utils;

/**
 self.battlestatus = {'ready':'0', 'id':'0000', 'ally':'0000', 'mode':'0', 'sync':'00', 'side':'00', 'handicap':'0000000'}
 battleStatus: An integer, but with limited range: 0..2147483647 (use signed int and consider only positive values and zero) This number is sent as text. Each bit has its meaning:

 b0 = undefined (reserved for future use)
 b1 = ready (0=not ready, 1=ready)
 b2..b5 = team no. (from 0 to 15. b2 is LSB, b5 is MSB)
 b6..b9 = ally team no. (from 0 to 15. b6 is LSB, b9 is MSB)
 b10 = mode (0 = spectator, 1 = normal player)
 b11..b17 = handicap (7-bit number. Must be in range 0..100). Note: Only host can change handicap values of the players in the battle (with HANDICAP command). These 7 bits are always ignored in this command. They can only be changed using HANDICAP command.
 b18..b21 = reserved for future use (with pre 0.71 versions these bits were used for team color index)
 b22..b23 = sync status (0 = unknown, 1 = synced, 2 = unsynced)
 b24..b27 = side (e.g.: arm, core, tll, ... Side index can be between 0 and 15, inclusive)
 b28..b31 = undefined (reserved for future use)


 */
public class StatusFormer {
    private int ready = 0;
    private int teamNo = 1111;
    private int ally = 1111;
    private int mode = 1;
    private int handicap = 1111111;
    private int sync = 11;
    private int side = 1111;

    public void setReady(int ready) {
        this.ready = ready;
    }

    public void setId(int teamNo) {
        this.teamNo = teamNo;
    }

    public void setAlly(int ally) {
        this.ally = ally;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    private int decimal;

    public String Status(){
        String temp = "0" + ready + teamNo + ally + mode + handicap + "0000" + sync + side + "0000";
        Long l = Long.parseLong(temp, 2);
        return l.toString();
    }
}
