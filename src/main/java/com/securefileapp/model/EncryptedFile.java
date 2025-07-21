package com.securefileapp.model;


public class EncryptedFile {

    private String name;
    private String type;
    private String hash;
    private byte[] encryptedContent;

    public EncryptedFile() {}

    public EncryptedFile(String name, String type, byte[] encryptedContent, String hash) {
        this.name = name;
        this.type = type;
        this.encryptedContent = encryptedContent;
        this.hash = hash;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public byte[] getEncryptedContent() {
        return encryptedContent;
    }

    public void setEncryptedContent(byte[] encryptedContent) {
        this.encryptedContent = encryptedContent;
    }

    // Convenience for compatibility with FileDecryptionService
    public String getFileName() {
        return getName();
    }

    public String getSha256Hash() {
        return getHash();
    }
}

