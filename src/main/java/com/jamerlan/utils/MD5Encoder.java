package com.jamerlan.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {
    public byte[] encode(String text) throws UnsupportedEncodingException {
        byte[] bytesOfMessage = text.getBytes("UTF-8");

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return md.digest(bytesOfMessage);
    }
}
