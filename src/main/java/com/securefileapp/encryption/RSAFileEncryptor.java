package com.securefileapp.encryption;

import javax.crypto.Cipher;
import java.security.*;

public class RSAFileEncryptor implements Encryptor {

    private final PublicKey publicKey;

    public RSAFileEncryptor() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        this.publicKey = keyPair.getPublic();

        // ⚠️ You may want to persist/save the private key for later decryption!
    }

    @Override
    public byte[] encrypt(byte[] content) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }
}
