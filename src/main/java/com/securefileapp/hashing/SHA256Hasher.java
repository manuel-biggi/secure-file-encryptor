package com.securefileapp.hashing;

import java.security.MessageDigest;

public class SHA256Hasher {
    public String hashBytes(byte[] data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashed = digest.digest(data);
        StringBuilder hex = new StringBuilder();
        for (byte b : hashed) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}
