package com.securefileapp.threading;

import com.securefileapp.encryption.AESEncryptor;
import com.securefileapp.encryption.Encryptor;
import com.securefileapp.hashing.SHA256Hasher;
import com.securefileapp.repository.FileRepository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;

public class EncryptionTask implements Runnable {
    private final File file;
    private final FileRepository repository;

    public EncryptionTask(File file, FileRepository repository) {
        this.file = file;
        this.repository = repository;
    }

    @Override
    public void run() {
        try {
            System.out.println("🔒 Encrypting: " + file.getName());

            byte[] content = Files.readAllBytes(file.toPath());
            SHA256Hasher hasher = new SHA256Hasher();
            String hash = hasher.hashBytes(content);

            Encryptor encryptor = new AESEncryptor(); // Or RSAFileEncryptor, XORFileEncryptor
            //ByteArrayOutputStream encrypted = encryptor.encrypt(content);
            byte[] encrypted = encryptor.encrypt(content);
            repository.saveFile(file.getName(), "aes", hash, encrypted);
            System.out.println("✅ Successfully encrypted and uploaded: " + file.getName());
        } catch (Exception e) {
            System.err.println("❌ Failed to process file: " + file.getName() + " → " + e.getMessage());
        }
    }
}
