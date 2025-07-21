package com.securefileapp.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<File> getAllFiles(File input) {
        List<File> files = new ArrayList<>();
        if (input.isFile()) {
            files.add(input);
        } else if (input.isDirectory()) {
            for (File f : input.listFiles()) {
                files.addAll(getAllFiles(f));
            }
        }
        return files;
    }
}
