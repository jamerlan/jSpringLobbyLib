package com.jamerlan;

import java.io.BufferedReader;
import java.io.IOException;

public class GameProcessor {
    public void process(BufferedReader reader) throws IOException {
        String output;
        while ((output = reader.readLine()) != null) {
            System.out.println("<<" + output);
        }
        reader.close();
    }
}
