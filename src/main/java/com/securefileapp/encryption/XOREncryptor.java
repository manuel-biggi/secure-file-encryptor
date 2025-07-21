package com.securefileapp.encryption;

public class XOREncryptor implements Encryptor {
    private static final byte XOR_KEY = (byte) 0xAA;

    @Override
    public byte[] encrypt(byte[] content) {
        byte[] encrypted = new byte[content.length];
        for (int i = 0; i < content.length; i++) {
            encrypted[i] = (byte) (content[i] ^ XOR_KEY);
        }
        return encrypted;
    }
}
