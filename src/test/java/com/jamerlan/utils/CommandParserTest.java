package com.jamerlan.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandParserTest {
    @Test
    public void testParser() throws Exception {
        String line = "BATTLEOPENED 20535 0 0 EvoRTSDedicated4 54.183.228.213 8254 8 0 0 540337253 Archers Battlefield - v05\tEvolution RTS Dedicated Host 4\tEvolution RTS - v10.17";
        CommandParser parser = new CommandParser(line);
        String first = parser.getString(" ");
        System.out.println(first);

        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getString(" "));
        System.out.println(parser.getString(" "));//ip
        System.out.println(parser.getInt(" "));//port
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getInt(" "));
        System.out.println(parser.getString("\t"));
        System.out.println(parser.getString("\t"));
        String gameName = parser.getString();
        System.out.println(gameName);

    }
}