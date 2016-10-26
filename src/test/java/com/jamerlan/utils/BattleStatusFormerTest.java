package com.jamerlan.utils;

import org.junit.Test;

/**
 * Created by Elt on 25.10.2016.
 */
public class BattleStatusFormerTest {
    public static String dec(int a) { return Integer.toString(a, 10); }

    public static void main(String[] args) {
        int ready = 2;
        int teamNo = 60; // 4-32
        int ally = 960; // 64-512
        int mode = 1024; // 1024
        int handicap = 243712; // 2048-131072
        int sync = (131072*4*4*2) + (131072*64);
        int side = (131072*128) + (131072*254) + (131072*512) + (131072*1024);
        String temp = "0" + ready + teamNo + ally + mode + handicap + "0000" + sync + side + "0000";
        String status = Integer.toBinaryString(ready+teamNo+ally+mode+handicap+sync+side);
        System.out.println(status);
    }

    @Test
    public void test() throws Exception {
        int inGame = 1;
        int away = 1;

        String temp = inGame + away + "00000";
        Long l = Long.parseLong(temp, 2);
        System.out.println(l);
    }
}
