package com.securefileapp.encryption;

// encryption/Decryptor.java
public interface Decryptor {
    byte[] decrypt(byte[] data) throws Exception;
}
