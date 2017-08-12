package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;
import com.jamerlan.utils.Base64Encoder;
import com.jamerlan.utils.MD5Encoder;

import java.io.IOException;
import java.io.PrintWriter;

/**
 TESTLOGIN userName password
 */
public class TestLogin implements Command<PrintWriter> {
    private String userName;
    private String password;

    public TestLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {
        String encodedPassword = new Base64Encoder().encodeToString(new MD5Encoder().encode(password));

        writer.println("TESTLOGIN " + userName + " " + encodedPassword);
    }
}
