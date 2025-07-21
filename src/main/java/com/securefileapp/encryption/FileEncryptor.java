package com.securefileapp.encryption;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileEncryptor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to a file or folder:");
        String path = scanner.nextLine();

        File fileOrDir = new File(path);
        if (!fileOrDir.exists()) {
            System.out.println("❌ Invalid path.");
            return;
        }

        System.out.println("Choose encryption type: AES / XOR");
        String encryptionType = scanner.nextLine().trim();

        Encryptor encryptor;
        try {
            encryptor = EncryptorFactory.getEncryptor(encryptionType);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return;
        }

        try {
            if (fileOrDir.isFile()) {
                File out = new File(fileOrDir.getAbsolutePath() + ".enc");

                byte[] content = Files.readAllBytes(fileOrDir.toPath());
                byte[] encryptedBytes = encryptor.encrypt(content);
                Files.write(out.toPath(), encryptedBytes);

                System.out.println("✅ File encrypted using " + encryptionType.toUpperCase() + ": " + out.getName());

            } else {
                encryptFolder(fileOrDir, encryptor);
                System.out.println("✅ Folder encrypted using " + encryptionType.toUpperCase());
            }
        } catch (Exception e) {
            System.out.println("❌ Encryption failed: " + e.getMessage());
        }
    }

    private static void encryptFolder(File folder, Encryptor encryptor) throws Exception {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                encryptFolder(file, encryptor);
            } else {
                byte[] content = Files.readAllBytes(file.toPath());
                byte[] encrypted = encryptor.encrypt(content);

                Path outPath = Paths.get(file.getAbsolutePath() + ".enc");
                Files.write(outPath, encrypted);

                System.out.println("📄 Encrypted: " + outPath.getFileName());
            }
        }
    }
}
