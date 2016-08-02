package com.jamerlan.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Base64Encoder {
    public byte[] encode(byte[] data) {
        return Base64.encodeBase64(data);
    }

    public String encodeToString(byte[] data) {
        try {
            return new String(Base64.encodeBase64(data), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
