package com.securefileapp.encryption;

import java.io.ByteArrayOutputStream;

public interface Encryptor {
    byte[] encrypt(byte[] content) throws Exception;
}

