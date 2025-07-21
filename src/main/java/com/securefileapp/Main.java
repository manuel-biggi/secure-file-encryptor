package com.securefileapp;

import com.securefileapp.repository.FileRepository;
import com.securefileapp.threading.EncryptionTask;
import com.securefileapp.threading.ThreadPool;
import com.securefileapp.utils.FileUtils;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("🔐 Welcome to SecureFileApp!");
        System.out.println("Please enter the full path to a file or folder:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        File input = new File(path);
        if (!input.exists()) {
            System.err.println("❌ Invalid file or folder path.");
            return;
        }

        List<File> files = FileUtils.getAllFiles(input);
        if (files.isEmpty()) {
            System.err.println("⚠️ No files found to encrypt.");
            return;
        }

        FileRepository repository = new FileRepository();
        ThreadPool pool = new ThreadPool(4); // 4 threads
        for (File file : files) {
            pool.submit(new EncryptionTask(file, repository));
        }
        pool.shutdown();
    }
}
