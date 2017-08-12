package com.jamerlan.commands;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * All parameters are passed to constructor of concrete command.
 */
public interface Command<T> {
    void execute(T arg) throws IOException;
}
