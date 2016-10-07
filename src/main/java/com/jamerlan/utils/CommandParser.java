package com.jamerlan.utils;

public class CommandParser {
    private String line;

    public CommandParser(String line) {
        this.line = line;
    }

    public int getInt(String delimiter) {
        int index = line.indexOf(delimiter);
        String chunk = line.substring(0, index);
        line = line.substring(index + 1);
        return Integer.parseInt(chunk);
    }

    public String getString(String delimiter) {
        int index = line.indexOf(delimiter);
        String chunk = line.substring(0, index);
        line = line.substring(index + 1);
        return chunk;
    }

    public String getString() {
        return line;
    }

    public Integer getInt() { return Integer.valueOf(line); }

    public boolean hasNext(String delimiter) {
        int index = line.indexOf(delimiter);
        return index != -1;
    }
}
