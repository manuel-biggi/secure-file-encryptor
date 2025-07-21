package com.securefileapp.encryption;

public class EncryptorFactory {
    public static Encryptor getEncryptor(String type) throws Exception {
        return switch (type.toLowerCase()) {
            case "aes" -> new AESEncryptor();
            case "xor" -> new XOREncryptor();
            case "rsa" -> new RSAFileEncryptor();
            default -> throw new IllegalArgumentException("Unsupported encryption type: " + type);
        };
    }
}


