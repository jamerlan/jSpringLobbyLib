package com.jamerlan.commands.impl.out;

import com.jamerlan.commands.Command;
import com.jamerlan.utils.Base64Encoder;
import com.jamerlan.utils.MD5Encoder;

import java.io.IOException;
import java.io.PrintWriter;

public class ChangePassword implements Command{
    private String oldPassword;
    private String newPassword;

    public ChangePassword(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    @Override
    public void execute(PrintWriter writer) throws IOException {

        final String encodedoldPassword = new Base64Encoder().encodeToString(new MD5Encoder().encode(oldPassword));
        final String encodednewPassword = new Base64Encoder().encodeToString(new MD5Encoder().encode(newPassword));
        writer.println("CHANGEACCOUNTPASS " + encodedoldPassword + " " + encodednewPassword);

    }
}
